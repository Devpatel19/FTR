import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CreateWorkitemService } from './create-workitem.service';

@Component({
  selector: 'app-create-workitem',
  templateUrl: './create-workitem.component.html',
  styleUrls: ['./create-workitem.component.css']
})
export class CreateWorkitemComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private cService: CreateWorkitemService) { }

  createForm!: FormGroup;
  errorMessage!: any;
  successObj!: any;

  ngOnInit(): void {
    this.createForm = this.formBuilder.group({
      userId: ['', [Validators.required, Validators.maxLength(5)]],
      itemName: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(25)]],
      itemType: ['', [Validators.required, Validators.minLength(4), Validators.maxLength(25)]],
      itemDescription: ['', [Validators.required, Validators.minLength(10), Validators.maxLength(45)]],
      messageToRecipient: ['', [Validators.required, Validators.minLength(10), Validators.maxLength(45)]],
      quantity: ['', [Validators.required, Validators.pattern("[0-9]{1,}")]],
      sourceCountry:['',[Validators.required,Validators.minLength(5),Validators.maxLength(25)]],
      destinationCountry:['',[Validators.required,Validators.minLength(5),Validators.maxLength(25)]],
      selectedHarborLocation:['',[Validators.required,Validators.minLength(5),Validators.maxLength(25)]],
      shippingDate:['',[Validators.required,Validators.pattern("[0-9]{2}-[a-zA-Z]{3}-[0-9]{4}")]]
    })

  }



  onSubmit() {
    this.successObj = null;
    this.errorMessage = null;

    this.cService.createWorkitem(this.createForm.value).subscribe({ 
      next: (data: any)=>{
        if(data.workitemId!=null){
          this.successObj = data;
        }else{
          this.errorMessage = data.message;
        }
      },
      error: (error:any) => this.errorMessage=error.error.message
    });
  }




  onBack() {
    window.history.back();
  }

}
