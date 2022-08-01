import { Injectable } from '@angular/core';
import { Terminal } from './add-terminal/Terminal';

import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import {Observable,throwError} from 'rxjs';
import {catchError} from 'rxjs/operators'


@Injectable({
  providedIn: 'root'
})
export class TerminalService {

  private baseURL = 'http://localhost:3000/ftr/terminals'
  constructor(private http:HttpClient) { }

  getAllTerminals(): Observable<Terminal[]> {
    return this.http.get<Terminal[]>(`${this.baseURL}`).pipe(catchError(this.handleError));
 }

 getTerminalById(terminalId:String) : Observable<Terminal> {
  return this.http.get<Terminal>(`${this.baseURL}` + '/fetchTerminalByTerminalId/' + terminalId).pipe(catchError(this.handleError));
 }

 addTerminal(terminal:Terminal) : Observable<Object>{
   return this.http.post(`${this.baseURL}`,terminal).pipe(catchError(this.handleError));
 }

 deleteTerminal(terminalId:String) : Observable<Object> {
   return this.http.delete(`${this.baseURL}/` + terminalId);
 }

 private handleError(err: HttpErrorResponse): Observable<any> {
  let errMsg = '';
  if (err.error instanceof Error) {
    console.log('An error occurred:', err.error.message);
    errMsg = err.error.message;
  } else {
    console.log(`Backend returned code ${err.status}`);
    errMsg = err.error.message;
    if(err.status == 0)
    {
      errMsg = "Server Refused to connect, Please try after sometime!!";
    }
  }
  return throwError(errMsg);
}
  
}
