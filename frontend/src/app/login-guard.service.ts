import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { LoginComponent } from './login/login.component';

@Injectable({
  providedIn: 'root'
})
export class LoginGuardService implements CanActivate {

  constructor(private loginService: LoginComponent,private router: Router) { }

 canActivate() : boolean{
 if(this.loginService.isUserLoggedIn){
  return true;
}
this.router.navigate(['/login']);
 return false;
 }
}
