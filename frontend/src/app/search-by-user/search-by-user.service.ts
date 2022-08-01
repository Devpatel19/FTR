import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SearchByUserService {

  constructor(private http:HttpClient) { }

  url:string = "http://localhost:9000/ftr/workItems/managed-user/"

  searchByUserId(userId:number):Observable<any>{
    const uri = this.url+userId;
    return this.http.get(uri).pipe(
      catchError(this.handleError)
    );
  }

  handleError(err:HttpErrorResponse):Observable<any>{
    let msg="";
    if (err.error instanceof Error) {
      msg=err.error.message;
    }else{
      msg = err.error.status;
    }
    return throwError(()=>msg)
  }







}
