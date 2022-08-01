

import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { User } from './user';
import { FormGroup,FormControl } from '@angular/forms';
import {LoginUser} from './LoginUser';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

isUserLoggedIn:boolean=false;
errormsg!:string;
userId!:string;
password!:string;
 userProfileForm=new FormGroup({
 
  userId: new FormControl(''),
  password: new FormControl(''),
});
  constructor(private router: Router, private userService: UserService) { }

 

  ngOnInit(): void {
  }

  validateAndSubmit(){
    console.log(this.userProfileForm.value);
    // console.warn(this.userProfileForm.controls['userId'].value);

   this.userId=this.userProfileForm.controls['userId'].value;
   this.password=this.userProfileForm.controls['password'].value;

   if(this.userId==''||this.password==''){
    this.errormsg="username or password is empty";
   }
   else{
    this.loginUserRequest();
   }
    
   
  }


  loginUserRequest(): LoginUser{

    let user=  this.loginUserObject();
this.userService.loginUser(user).subscribe(data =>{
 
  this.router.navigate(['viewUserProfile',user.userId]);
  console.log(data);
  alert("user logged in successfuly");

  this.isUserLoggedIn=true;

},error =>{


    this.errormsg="Invalid userId/password";
    this.isUserLoggedIn=false;
  
    console.log(error);
  
})
  return user;
  }

 
  loginUserObject(){
    let user=new LoginUser();
    user.userId=this.userProfileForm.controls['userId'].value;
    user.password=this.userProfileForm.controls['password'].value;
   
    console.log("login" + user.userId);
    console.log(user.password);
  return user;
  }


}


function data(data: any) {
  throw new Error('Function not implemented.');
}
