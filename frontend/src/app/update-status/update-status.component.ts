import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UpdateStatusService } from './update-status.service';

@Component({
  selector: 'app-update-status',
  templateUrl: './update-status.component.html',
  styleUrls: ['./update-status.component.css']
})
export class UpdateStatusComponent implements OnInit {
  workit: any;

  constructor(private formBuilder: FormBuilder,private updateService:UpdateStatusService) { }

  updateForm!:FormGroup;
  errorMessage!:any;
  successMessage!:any;


  ngOnInit(): void {
    console.log(this.updateService.vNumber);
    this.updateForm = this.formBuilder.group({
      workitemId:[this.updateService.vNumber,[Validators.required, Validators.maxLength(5)]]

  })

  }
  
  onSubmit(){
    this.successMessage=null;
    this.errorMessage=null;
    if(this.workit)
    this.updateService.updateStatus(this.updateForm.value.workitemId).subscribe({ 
      next: (data: any)=>{if(data.message){
        this.successMessage=data.message;
      }else{
        this.errorMessage=data.error.message
      }
      error: (error:any) => this.errorMessage=error.error.message;
  }});
  }




  onBack(){
    window.history.back();
  }


}
