// import { Injectable } from '@angular/core';

// @Injectable({
//   providedIn: 'root'
// })
// export class UserService {

//   constructor() { }
// }


import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './login/user';
import { Observable } from 'rxjs';
import { LoginUser } from './login/LoginUser';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseURL="http://localhost:9000/ftr/userProfile";
  // private baseURL = "http://localhost:8080/v1/employees";
  constructor(private httpClient:HttpClient) { }

  createUser(user: User): Observable<Object>{
    console.warn(user);
    return this.httpClient.post(`${this.baseURL}`,user);
  }
 

  getUser(id:number): Observable<User>{
    console.warn(id);
    return this.httpClient.get<User >(`${this.baseURL}/${id}`);
  }

  loginUser(loginUserObject: LoginUser) :Observable<any>{

    let url=this.baseURL+"/login";
    return this.httpClient.post<any>(url,loginUserObject);
  }

  updateUser(id:number,user: User): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`,user);
  }

  deleteUser(id:number): Observable<any>{

    return this.httpClient.delete(`${this.baseURL}/${id}`);

  }
  
}
