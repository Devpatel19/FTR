import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-fetch-by-name',
  templateUrl: './fetch-by-name.component.html',
  styleUrls: ['./fetch-by-name.component.css']
})
export class FetchByNameComponent implements OnInit {

  showVehicles=false;
  loginForm : FormGroup;
  sucessMessage!:String;
  vehicleName!:String;
  vehicles!: any[];// =
  
  // [{
  //   "vehicleNumber":"UE7890", "vehicleName":"Tower crane",
  //   "maxLiftingCapacity(In Tons)": "19.8",
  //   "retireDate":"20-Dec-30",
  //   "vehicleStatus":"Active","country":"Singapore","harborLocation":"Sydney Harbor"
  //   },       {
  //   "vehicleNumber":"KY8876", "vehicleName":"Tower crane",
  //   "maxLiftingCapacity(In Tons)": "19.9",
  //   "retireDate":"29-Jun-2030",
  //   "vehicleStatus":"InActive","country":"Australia","harborLocation":"Sydney Harbor"
  //   }] 

  constructor(private formBuilder: FormBuilder,private http: HttpClient) {
  
    this.loginForm = this.formBuilder.group({
      
      vehicleName: [null, [Validators.required ]]
  
    });
  }

  ngOnInit(): void {
  }

  viewVehicles() {
    this.showVehicles=true;
    this.vehicleName = this.loginForm.controls['vehicleName'].value
    console.log("vehicleName",this.vehicleName);
    this.http.get('http://localhost:9000/ftr/vehicles/managed-name/' + this.vehicleName).subscribe(response => {
      console.log('result of sequqncecs:',response);
      if (response) {
      this.vehicles = response as any[];

      }

    }, (err: HttpErrorResponse) => {
      console.log('result of sequqncecs:', err['error']['message']);
      this.showVehicles = false;
      this.sucessMessage = err['error']['message'];

    });

  }

}