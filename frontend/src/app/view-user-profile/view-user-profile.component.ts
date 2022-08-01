import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../login/user';
// import { RestService } from '../rest.service';
import { UserService } from '../user.service';
@Component({
  selector: 'app-view-user-profile',
  templateUrl: './view-user-profile.component.html',
  styleUrls: ['./view-user-profile.component.css']
})
export class ViewUserProfileComponent implements OnInit {

  // @Input() Idd!: string;
  
  // employees!: Employee[];
error!:string;
userObj!:User;

// details!:any;
 
  validate:boolean=false;
  Id!:number;
  
  constructor(private userService: UserService,private router: Router,private route: ActivatedRoute) {}

  ngOnInit(): void {
 
    this.Id=this.route.snapshot.params['id'];
    this.viewUser();
  }
 

  viewUser(){
    this.userService.getUser(this.Id).subscribe(data =>{
      // console.warn(this.Id);
    
    this.userObj=data;
    this.error="";
      console.warn(this.userObj);
      
    },error=>{
      this.userObj={} as any;
      console.log(this.userObj);
      this.error="User doesn't exist";
    })
  }
  


 
 
  updateUser(){
    this.router.navigate(['updateUserProfile',this.Id]);
  }


  removeUser(){
    if (confirm("Are You Sure to Delete???") == true) {

      this.userService.deleteUser(this.Id).subscribe(data =>{
        this.router.navigate(['login']);
      },error =>{
        this.router.navigate(['login']);
        console.log(error);
      })

      // console.log("ok "+this.Id);
    } else {
      console.log("no");
    }
  }


  toggle(){
    // console.log(this.Idd);
    this.validate=this.validate?false:true;
  }
}
