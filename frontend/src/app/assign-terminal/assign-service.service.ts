import { HttpClient, HttpErrorResponse } from '@angular/common/http';

import { Injectable } from '@angular/core';
import { catchError, Observable, tap, throwError } from 'rxjs';

@Injectable({
providedIn: 'root'
})
export class AssignServiceService{

  constructor(private http:HttpClient) {}

  url:string = "http://localhost:9000/ftr/workItems/managed-terminal/";

  assignTerminal (id:string): Observable<any>{
    let url=this.url+id;
    return this.http.post<any>(url, id).pipe( 
      tap(data=>console.log(JSON.stringify(data))),
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