import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-admin',
  templateUrl: './login-admin.component.html',
  styleUrls: ['./login-admin.component.css']
})
export class LoginAdminComponent implements OnInit {

  err!:string;
  userId:string="";
  password:string="";
 adminDetails=[
  {"userID": "admin","password":"admin"},
 
 ];
  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  authenticate(){
 
    if(this.userId==this.adminDetails[0].userID&&this.password==this.adminDetails[0].password)
    {
      console.log("inside");
      alert("logged in successfuly");
      this.router.navigate(['admin/dashboard']);
      this.err="";
    }
    else if(this.userId==""||this.password=="")
    {
      this.err="userId/Password can't be empty";
    }
    else{
      this.err="userId/password is Invalid";
    }
   
  }

}
