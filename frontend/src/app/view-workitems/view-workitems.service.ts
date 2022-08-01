import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { catchError, Observable, throwError,tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ViewWorkitemsService{

  constructor(private http: HttpClient) { }




  url="http://localhost:9000/ftr/workItems/"

  fetchAllWorkitems():Observable<any>{
    return this.http.get(this.url).pipe(
      // tap(data=>console.log(JSON.stringify(data))),
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
