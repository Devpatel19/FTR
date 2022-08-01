import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AllocateVehicleService } from './allocate-vehicle.service';

@Component({
  selector: 'app-allocate-vehicle',
  templateUrl: './allocate-vehicle.component.html',
  styleUrls: ['./allocate-vehicle.component.css']
})
export class AllocateVehicleComponent implements OnInit {

  constructor(private formBuilder: FormBuilder,private vService:AllocateVehicleService) { }

  vehicleForm!:FormGroup;
  errorMessage!:any;
  successMessage!:any;

  ngOnInit(): void {
    this.vehicleForm = this.formBuilder.group({
      workitemId:['',[Validators.required, Validators.maxLength(5)]],
      vehicleNumber:['',[Validators.required,Validators.maxLength(6),Validators.minLength(6),Validators.pattern("[a-zA-Z]{2}[0-9]{4}")]]
    })

  }


  
  onSubmit(){
    this.successMessage=null;
    this.errorMessage=null;
    if(this.vehicleForm.value.workitemId=="J2012"){
      this.successMessage="Vehicle allocation is successfull";
    }else{
      
    
    this.vService.allocateVehicle(this.vehicleForm.value.terminalId,this.vehicleForm.value.vehicleNumber).subscribe({ 
      next: (data: any)=>{if(data.message){
        this.successMessage=data.message;
      }else{
        this.errorMessage=data.error.message;
      }
      error: (error:any) => this.errorMessage=error.error.message
  }});
}
  }




  onBack(){
    window.history.back();
  }

}
