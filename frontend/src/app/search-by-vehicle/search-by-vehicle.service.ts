import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError,tap } from 'rxjs';
import { Vehicle } from './vehicle';

@Injectable({
  providedIn: 'root'
})
export class SearchByVehicleService {

  constructor(private http:HttpClient) { }

  url:string = "http://localhost:9000/ftr/workItems/managed-vehicle/"

  searchByVehicleNumber(vehicleNumber:string):Observable<any>{
    const uri = this.url+vehicleNumber;
    return this.http.get<any>(uri).pipe(
      tap(data=>console.log(JSON.stringify(data))),
      catchError(this.handleError)
    );
  }

  handleError(err:HttpErrorResponse){
    let msg="";
    if (err.error instanceof Error) {
      msg=err.error.message;
    }else{
      msg = err.error.status;
    }
    return throwError(()=>msg)
  }












}
