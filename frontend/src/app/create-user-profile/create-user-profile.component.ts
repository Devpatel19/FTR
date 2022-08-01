// import { Component, OnInit } from '@angular/core';

// @Component({
//   selector: 'app-create-user-profile',
//   templateUrl: './create-user-profile.component.html',
//   styleUrls: ['./create-user-profile.component.css']
// })
// export class CreateUserProfileComponent implements OnInit {

//   constructor() { }

//   ngOnInit(): void {
//   }

// }
import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { User } from '../login/user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-create-user-profile',
  templateUrl: './create-user-profile.component.html',
  styleUrls: ['./create-user-profile.component.css']
})
export class CreateUserProfileComponent implements OnInit {

  
  pId!:boolean;
  em!:boolean;
  mb!:boolean;
  pp!:boolean;
  pw!:boolean;
  status!:string;
  sts:boolean=false;
 
  user: User=new User();
  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }
  saveUser(){
    this.userService.createUser(this.user).subscribe(data =>{
      console.log(data);
      this.sts=true;
     this.status="saved successfully";
    
    },
    (error =>{
     
 
      this.status="Invalid Details";
      this.sts=false;
       console.log(error);
   
      }));
  }
  Onsubmit(){
    console.log(this.user);
  
   
    
    this.saveUser();
  }

 
  pIdNo(){
    this.pId=this.pId?false:true;
  }
  email()
  {
    this.em=this.em?false:true;
  }
  mob(){
    this.mb=this.mb?false:true;
  }
  passP(){
    this.pp=this.pp?false:true;
  }
  pwd(){
    this.pw=this.pw?false:true;
  }
}

