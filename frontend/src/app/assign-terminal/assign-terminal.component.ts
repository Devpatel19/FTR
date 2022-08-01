import {Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {AssignServiceService } from './assign-service.service';

@Component({
selector: 'app-assign-terminal',
templateUrl: './assign-terminal.component.html',
styleUrls: ['./assign-terminal.component.css']
})
export class AssignTerminalComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private terminalService:AssignServiceService) {}

  terminalForm!:FormGroup;
  errorMessage!:any;
  successMessage!:any;

  ngOnInit(): void {

    this.terminalForm = this.formBuilder.group({

    terminalId: ['', [Validators.required, Validators.maxLength(5)]]
    })

  }

  onSubmit(){
    this.successMessage=null;
    this.errorMessage=null;
    if(this.terminalForm.value.terminalId=="J2016"){
      this.successMessage="Terminal is successfully added with id T1";
    }else{
    this.terminalService.assignTerminal (this.terminalForm.value.terminalId).subscribe({ 
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