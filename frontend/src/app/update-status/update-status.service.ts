import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UpdateStatusService {

  constructor(private http:HttpClient) { }

  url:string = "http://localhost:9000/ftr/workItems/managed-update/";

  vNumber!:string;

  setVehicleNumber(vehicleNumber:string){
    this.vNumber=vehicleNumber;

  }

  updateStatus(workitemId:string):Observable<any>{
    const headers = new HttpHeaders();
     headers.append('Access-Control-Allow-Headers', 'Content-Type');
      headers.append('Access-Control-Allow-Methods', '*');
       headers.append('Access-Control-Allow-Origin', '*');



    const uri:string = this.url+workitemId;
    return this.http.put(uri,workitemId).pipe(
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
