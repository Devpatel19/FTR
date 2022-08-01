import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable,tap, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CreateWorkitemService {

  constructor(private http:HttpClient) { }

  url="http://localhost:9000/ftr/workItems";

  createWorkitem(formObj:any):Observable<any>{
    return this.http.post(this.url,formObj).pipe(
      tap((data:any)=>console.log(JSON.stringify(data))),
      catchError(this.handleError)
    )
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
