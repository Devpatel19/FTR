package com.example.demo.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.controller.TerminalCustFeign;
import com.example.demo.controller.VehicleCustFeign;
import com.example.demo.dto.FtrHarborDTO;
import com.example.demo.dto.FtrVehicleWorkitemDTO;
import com.example.demo.dto.FtrWorkitemsDTO;
import com.example.demo.dto.TerminalDTO;
import com.example.demo.dto.VehicleDTO;

import com.example.demo.entity.FtrHarbor;
import com.example.demo.entity.FtrVehicleWorkitem;
import com.example.demo.entity.FtrWorkitemTerminal;
import com.example.demo.entity.FtrWorkitems;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.FtrHarborRepository;
import com.example.demo.repository.FtrVehicleWorkitemRepository;
import com.example.demo.repository.FtrWorkitemTerminalRepository;
import com.example.demo.repository.FtrWorkitemsRepository;
import com.fasterxml.jackson.annotation.JsonFormat;



@Service
public class FtrWorkitemsService {
	private Integer count=3000;
	
	
	private Integer computerHardwarePrice = 15999;
	private float oilContainerPrice =(float) 22.54;
	private Integer woodPrice =130000;
	private Integer motorCyclesPrice=6336;
	private Integer electronicsPrice=1349;
	
	
	private String computerHardware ="Computer Hardware";
	private String oilContainer ="Oil Container";
	private String wood ="Wood";
	private String motorCycles="Motor Cycles";
	private String electronics="Electronics";
	
	@Autowired
	FtrWorkitemsRepository workitemRepo;
	
	@Autowired
	FtrVehicleWorkitemRepository vehicleRepo;
	
	@Autowired
	FtrWorkitemTerminalRepository terminalRepo;
	
	@Autowired
	FtrHarborRepository harborRepo;
	
	@Autowired
	TerminalCustFeign tCustFeign;
	
	@Autowired
	VehicleCustFeign vCustFeign;
	public FtrWorkitemsDTO createWorkitem(FtrWorkitemsDTO workitem) {
		
		String id = "J"+count;
		count++;
		
		FtrWorkitems ftrWorkitem = FtrWorkitemsDTO.prepareFtrWorkitems(workitem);
		ftrWorkitem.setWorkitemId(id);
		String item = ftrWorkitem.getItemType();
		String quantity = ftrWorkitem.getQuantity().split(" ")[0];
		Integer quantityInt = Integer.parseInt(quantity);
		Integer price=0;
		System.out.println(item);
		if(item.equals(computerHardware) || item=="Computer Hardware") {
			price = quantityInt*computerHardwarePrice;
		}else if(item.equals(oilContainer)) {
			price = (int) ((Integer) quantityInt*oilContainerPrice);
		}else if(item.equals(wood)) {
			price = quantityInt*woodPrice;
		}else if(item.equals(motorCycles)) {
			price = quantityInt*motorCyclesPrice;
		}else if(item.equals(electronics)) {
			price=quantityInt*electronicsPrice;
		}

		FtrVehicleWorkitem vehicle = new FtrVehicleWorkitem();
		vehicle.setWorkitemId(ftrWorkitem.getWorkitemId());
		
		FtrWorkitemTerminal terminal = new FtrWorkitemTerminal();
		terminal.setWorkitemId(ftrWorkitem.getWorkitemId());
		
		
		ftrWorkitem.setAmount(price);
		ftrWorkitem.setFtrVehicleWorkitem(vehicle);
		ftrWorkitem.setFtrWorkitemTerminal(terminal);
		workitemRepo.save(ftrWorkitem);
		FtrWorkitemsDTO ftrWorkitemDTO = FtrWorkitems.prepareFtrWorkitemsDTO(ftrWorkitem);
		return ftrWorkitemDTO;
	}
	
	
	public FtrVehicleWorkitemDTO getVehicleData(Long userId) throws UserNotFoundException {
		Optional<FtrWorkitems> o = Optional.ofNullable(workitemRepo.findByUserId(userId));

		if(o.isPresent()) {
			FtrWorkitems workitems = o.get();
			FtrVehicleWorkitemDTO vehicleDTO = FtrVehicleWorkitem.prepareFtrVehicleWorkitemDTO(workitems.getFtrVehicleWorkitem());
			return vehicleDTO;
		}else {
			throw new UserNotFoundException("Workitem details not found for given user id");
		}
		
	}
	
	public String assignTerminalForWorkItem(String workItemId) throws UserNotFoundException{
		Optional<FtrWorkitems> o = Optional.ofNullable(workitemRepo.findByWorkitemId(workItemId));
		if(o.isPresent()) {
			FtrWorkitems workitem = o.get();
			Integer capacity = Integer.parseInt(workitem.getQuantity().split(" ")[0]);
			
			List<TerminalDTO> terminalList = tCustFeign.fetchListOfTerminals(workitem.getItemType());
			TerminalDTO newTerminal = new TerminalDTO();
			for(TerminalDTO t : terminalList) {
				if((t.getCapacity()>=capacity) && t.getStatus().equals("AVAILABLE")) {
					newTerminal = t;
					break;
				}
			}
			if(newTerminal.getTerminalId()!=null) {
				String terminalId = newTerminal.getTerminalId();
				String response = tCustFeign.updateTerminal(terminalId,capacity);
				FtrWorkitemTerminal ftrWorkitemTerminal = new FtrWorkitemTerminal();
				ftrWorkitemTerminal.setWorkitemId(workItemId);
				ftrWorkitemTerminal.setTerminalId(terminalId);
				workitem.setFtrWorkitemTerminal(ftrWorkitemTerminal);
				workitemRepo.save(workitem);
				return "Workitem successfully allocated to terminal id";
				
			}else {
				throw new  UserNotFoundException("There are no terminals available for this workitem capacity");
			}
		}else {
			throw new UserNotFoundException("Workitem details not found for given work id");
		}
	}
	
	
	public String allocateVehicle(String workItemId,FtrVehicleWorkitemDTO vehiclWiDTO) throws UserNotFoundException{
		Optional<FtrWorkitems> o = Optional.ofNullable(workitemRepo.findByWorkitemId(workItemId));
		if(o.isPresent()) {
			FtrWorkitems workitem =o.get();
			if(workitem.getFtrVehicleWorkitem().getVehicleNumber()!=null) {
				String selectedHarborLocation = workitem.getSelectedHarborLocation();
				List<VehicleDTO> vehicleList = vCustFeign.fetchAllVehicles().stream()
						.filter(v-> v.getHarborLocation().equals(workitem.getSelectedHarborLocation()) && v.getVehicleStatus().equals("Active"))
						.collect(Collectors.toList());
				if(!vehicleList.isEmpty()) {
					FtrVehicleWorkitemDTO vehicleWorkitem = new FtrVehicleWorkitemDTO();
					vehicleWorkitem.setWorkitemId(workItemId);
					vehicleWorkitem.setVehicleNumber(vehicleList.get(0).getVehicleNumber());
					vehicleWorkitem.setAssignedWorkitemStatus("InProgress");
					
					return "Workitem details are successfully updated";
				}else {
					return "vehicle not available.";
				}
			}else {
				return "workitem is already allocated with vehicle";
			}
//			
		}else {
			throw new UserNotFoundException("Workitem details not found for given work id");
		}
		
	}
	public List<FtrWorkitemsDTO> fetchWorkitemsDetails(){
		List<FtrWorkitems> items=workitemRepo.findAll();
		List<FtrWorkitemsDTO> dtolist=new ArrayList<>();
		for(FtrWorkitems item:items) {
			FtrWorkitemsDTO Dto=item.prepareFtrWorkitemsDTO(item);
			dtolist.add(Dto);
		}
		return dtolist;
	}
	public List<String> fetchAvailableHarborLocations(String country) throws UserNotFoundException{
		Optional<FtrHarbor> o=Optional.ofNullable(harborRepo.findByCountry(country));
		if(o.isPresent()) {
			FtrHarbor harbor=o.get();
		String str=harbor.getAvailableHarborLocations();
		 String[] harbors=str.split(",");
		 List<String> al = new ArrayList<String>();
			al = Arrays.asList(harbors);
		return al;
		}
		else {
			throw new UserNotFoundException("country not found");
		}
		
	}
	public FtrVehicleWorkitemDTO fetchWorkitemStatus(String workitemId) throws UserNotFoundException {
		Optional<FtrVehicleWorkitem> o=Optional.ofNullable(vehicleRepo.findByWorkitemId(workitemId));
		if(o.isPresent()) {
			FtrVehicleWorkitem vehicle=o.get();
		   FtrVehicleWorkitemDTO dto=vehicle.prepareFtrVehicleWorkitemDTO(vehicle);
		   return dto;
		  }else {
			  throw new UserNotFoundException("Invalid data");
		  }
		
	}
	public String updateWorkitem(String workitemId,FtrWorkitemsDTO workitemDTO) throws UserNotFoundException{
		 Optional<FtrWorkitems> o=Optional.ofNullable(workitemRepo.findByWorkitemId(workitemId));
		 FtrWorkitems item=o.get();
		 if(o.isPresent()) {
		 LocalDate date=workitemDTO.getShippingDate();
		 if(date!=null) {
		 item.setShippingDate(date);
		 }
		 String country=item.getDestinationCountry();
		 FtrHarbor harbor=harborRepo.findByCountry(country);
		 String str=harbor.getAvailableHarborLocations();
		 String harbors[]=str.split(", ");
		 List<String> al = new ArrayList<String>();
		 al = Arrays.asList(harbors);
		 for(String s:al) {
			 System.out.println(s);
		 }
		 String s=workitemDTO.getSelectedHarborLocation();	 
		 System.out.println(s);
		 if(al.contains(s)) {
			 item.setSelectedHarborLocation(s);
			 System.out.println("updated");
		 }	
		 workitemRepo.save(item);
		 return "successfully updated";
		 }
		 else {
			 throw new UserNotFoundException("Invalid data");
		 }
	}
	
	public String updateWorkItemStatus(String workitemId) throws UserNotFoundException{
		Optional<FtrWorkitems> o = Optional.ofNullable(workitemRepo.findByWorkitemId(workitemId));
		if(o.isPresent()) {
			FtrWorkitems workitem = o.get();
			Date shippingDate = Date.from(workitem.getShippingDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
			Date currentDate = new Date();
			Long difference = currentDate.getTime() - shippingDate.getTime();
			if(difference>0) {
				workitem.getFtrVehicleWorkitem().setAssignedWorkitemStatus("Completed");
				workitemRepo.save(workitem);
				VehicleDTO vDTO = new VehicleDTO();
				vDTO.setVehicleStatus("Active");
				vCustFeign.updateVehicleStatus(vDTO);
				String quantity = workitem.getQuantity().split(" ")[0];
				Integer quantityInt = Integer.parseInt(quantity);
				tCustFeign.incTerminalCapacity(workitem.getFtrWorkitemTerminal().getTerminalId(),quantityInt);
				return "WorkItem details are successfully updated";
				
			}else {
				return "Working Status remains unchanged.";
			}

		}else {
			throw new UserNotFoundException("Workitem details not found for given work id");
		}
	
	}	 
}
