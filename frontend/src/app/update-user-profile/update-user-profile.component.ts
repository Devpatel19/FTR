import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../login/user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-update-user-profile',
  templateUrl: './update-user-profile.component.html',
  styleUrls: ['./update-user-profile.component.css']
})
export class UpdateUserProfileComponent implements OnInit {

  // userObj!:User;
  user: User=new User();
  id!:number;
  clicked:boolean=false;

  constructor(private userService: UserService,private route:ActivatedRoute,private router: Router) { }

  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];
    this.userService.getUser(this.id).subscribe(data =>{
      this.user=data;

    },error => console.log(error));

 

    
  }

  onSubmit(){

    this.userService.updateUser(this.id,this.user).subscribe(data =>{
      console.log("data updated");
      // this.goBack();
      this.router.navigate(['viewUserProfile',this.id]);
    },error =>{
      this.router.navigate(['viewUserProfile',this.id]);
      console.log(error);
    })
  }

  goBack(){
    window.history.back();
    
  }

  click(){
    this.clicked=this.clicked?false:true;
  }
}
