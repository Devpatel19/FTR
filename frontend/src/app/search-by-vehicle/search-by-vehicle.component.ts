import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SearchByVehicleService } from './search-by-vehicle.service';
import { UpdateStatusService } from '../update-status/update-status.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search-by-vehicle',
  templateUrl: './search-by-vehicle.component.html',
  styleUrls: ['./search-by-vehicle.component.css']
})
export class SearchByVehicleComponent implements OnInit {

  constructor(private formBuilder:FormBuilder,private searchService:SearchByVehicleService,private updateService:UpdateStatusService,private router:Router) { }

  searchForm!:FormGroup;
  errorMessage!:any;

  responseObject!:any;

  ngOnInit(): void {
    this.searchForm = this.formBuilder.group({
      vehicleNumber:['',[Validators.required,Validators.maxLength(6),Validators.minLength(6),Validators.pattern("[a-zA-Z]{2}[0-9]{4}")]]
    })
  }

  onSubmit(){
    this.responseObject=null;
    this.errorMessage=null;

    this.searchService.searchByVehicleNumber(this.searchForm.value.vehicleNumber).subscribe({ 
      next: data =>{
        if(data.vehicleNumber){
          this.responseObject=data
        }else{
          this.errorMessage=data.message
        }
      },
      error:error=> this.errorMessage= <any>error
    });

  }

  onUpdate(){
    this.updateService.setVehicleNumber(this.responseObject.workitemId);
    this.router.navigate(['admin/dashboard/workitems/update']);
  }




  onBack(){
    window.history.back();
  }


















}
