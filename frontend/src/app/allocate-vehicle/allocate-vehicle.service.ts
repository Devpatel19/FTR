import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { tap,catchError, Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AllocateVehicleService {

  constructor(private http:HttpClient) { }

  url:string = "http://localhost:9000/ftr/workItems/managed-vehicle/";

  allocateVehicle(workitemId:string,vNumber:string):Observable<any>{
    const obj = {
      vehicleNumber:vNumber
    };
    const uri:string = this.url+workitemId;
    return this.http.post(uri,obj).pipe(
      tap(data=>console.log(JSON.stringify(data))),
      catchError(this.handleError)
    )
  
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
