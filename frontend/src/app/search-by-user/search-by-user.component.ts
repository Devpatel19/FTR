import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UpdateStatusService } from '../update-status/update-status.service';
import { SearchByUserService } from './search-by-user.service';

@Component({
  selector: 'app-search-by-user',
  templateUrl: './search-by-user.component.html',
  styleUrls: ['./search-by-user.component.css']
})
export class SearchByUserComponent implements OnInit {

  constructor(private formBuilder:FormBuilder,private searchService:SearchByUserService) { }

  searchForm!:FormGroup;
  errorMessage!:any;

  responseObject!:any;

  ngOnInit(): void {
    this.searchForm = this.formBuilder.group({
      userId:['',[Validators.required,Validators.maxLength(5),Validators.pattern("[0-9]{1,}")]]
    })
  }

  onSubmit(){
    this.responseObject=null;
    this.errorMessage=null;

    this.searchService.searchByUserId(this.searchForm.value.userId).subscribe({ 
      next: (data: any)=>{
        if(data.vehicleNumber){
          this.responseObject = data
        }else{
          this.errorMessage=data.message
        }
      },
      error: (error:any) => this.errorMessage=error.error.message
    });
  }




  onBack(){
    window.history.back();
  }


















}
