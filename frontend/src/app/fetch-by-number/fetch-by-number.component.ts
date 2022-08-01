import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-fetch-by-number',
  templateUrl: './fetch-by-number.component.html',
  styleUrls: ['./fetch-by-number.component.css']
})
export class FetchByNumberComponent implements OnInit {


  showVehicles=false;
  loginForm : FormGroup;
  sucessMessage!:String;
  vehicleNumber!:String;
  vehicles!: any ;
  vehicleName!: String;
  maxLiftingCapacity!: String;
  retireDate!: String;
  vehicleStatus!: String;
  harborLocation!: String;
  country!: String;
  r! : any[];
  stringifiedData: any;
  parsedJson: any;
  // =
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
      
      vehicleNumber: [null, [Validators.required ]]
  
    });
  }

  ngOnInit(): void {
  }


  viewVehicles() {
    this.showVehicles=true;
    // this.vehicleNumber = this.loginForm.controls.vehicleName.value
    this.vehicleNumber = this.loginForm.controls['vehicleNumber'].value
    console.log("vehicleName",this.vehicleNumber);
    console.log("vehicleName",'http://localhost:8003/ftr/vehicles/managed-number/' + this.vehicleNumber);
    this.http.get('http://localhost:9000/ftr/vehicles/managed-number/' + this.vehicleNumber).subscribe(response => {
      console.log("res:",response as any[]);
      if (response) 
      {this.stringifiedData = JSON.stringify(response);
        this.parsedJson = JSON.parse(this.stringifiedData);
        console.log(this. stringifiedData);
        console.log("With Parsed JSON :" , this.parsedJson['country']);

        
      // this.vehicles = response ;
      this.vehicleName =  this.parsedJson['vehicleName'];
      this.maxLiftingCapacity =  this.parsedJson['maxLiftingCapacity'];
       this.retireDate =  this.parsedJson['retireDate'];
       this.vehicleStatus =  this.parsedJson['vehicleStatus'];
       this.harborLocation =  this.parsedJson['harborLocation' ];
       this.country =  this.parsedJson['country' ];

      }
      

    }, (err: HttpErrorResponse) => {
      console.log('result of sequqncecs:', err['error']['message']);
      //this.showVehicles = false;
      this.sucessMessage = err['error']['message'];

    });

  }

}
