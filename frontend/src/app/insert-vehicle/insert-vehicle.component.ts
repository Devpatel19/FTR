import { DatePipe } from '@angular/common';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-insert-vehicle',
  templateUrl: './insert-vehicle.component.html',
  styleUrls: ['./insert-vehicle.component.css']
})
export class InsertVehicleComponent implements OnInit {


  loginForm: FormGroup;
  sucessMessage!: String;
  failureMessage!:String;
  showVehicles = false;

  constructor(private formBuilder: FormBuilder, private http: HttpClient,public datepipe: DatePipe) { 


    this.loginForm = this.formBuilder.group({
      vehicleNumber: [null, Validators.required],
      vehicleName: [null, [Validators.required , Validators.maxLength(50)]],
      maxLiftingCapacity: ['', Validators.required],
      retireDate: ['', Validators.required],
      vehicleStatus: [null, Validators.required],
      harborLocation: [null, [Validators.required , Validators.maxLength(25), Validators.minLength(5)]],
      country: [null, [Validators.required , Validators.maxLength(25), Validators.minLength(5)]]
    });
  }

  ngOnInit(): void {
  }


  addVehicle() {

    var datePipe = new Date(this.loginForm.controls['retireDate'].value);
    let latest_date =this.datepipe.transform(datePipe, 'dd-MMM-yyyy');
    let createObject = {
      vehicleNumber: this.loginForm.controls['vehicleNumber'].value,
      vehicleName: this.loginForm.controls['vehicleName'].value,
      maxLiftingCapacity: this.loginForm.controls['maxLiftingCapacity'].value,
      // retireDate: this.loginForm.controls['retireDate'].value,
      retireDate: latest_date,
      vehicleStatus: this.loginForm.controls['vehicleStatus'].value,
      harborLocation: this.loginForm.controls['harborLocation'].value,
      country: this.loginForm.controls['country'].value
    };

    console.log("create Object",createObject)

    this.showVehicles = true;
    this.http.post('http://localhost:9000/ftr/vehicles' ,createObject).subscribe(response => {

      console.log('result of response:',response);
      if (response) {
      //this.sucessMessage = response['message'];

      }

    }, (err: HttpErrorResponse) => {
      console.log('result of sequqncecs:', err);
      this.sucessMessage = err['error']['text'];
      this.failureMessage=err['error']['message'];

    });

  }

}