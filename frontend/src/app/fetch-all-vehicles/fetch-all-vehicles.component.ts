import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-fetch-all-vehicles',
  templateUrl: './fetch-all-vehicles.component.html',
  styleUrls: ['./fetch-all-vehicles.component.css']
})
export class FetchAllVehiclesComponent implements OnInit {


  constructor(private http: HttpClient) { }

  vehicles!: any[] ;
  parsedJson: any;  
  stringifiedData: any;
  // =
  
  //   [{
  //     "vehicleNumber":"UE7890", "vehicleName":"Tower crane",
  //     "maxLiftingCapacity(In Tons)": "19.8",
  //     "retireDate":"20-Dec-30",
  //     "vehicleStatus":"Active","country":"Singapore","harborLocation":"Sydney Harbor"
  //     },       {
  //     "vehicleNumber":"KY8876", "vehicleName":"Tower crane",
  //     "maxLiftingCapacity(In Tons)": "19.9",
  //     "retireDate":"29-Jun-2030",
  //     "vehicleStatus":"InActive","country":"Australia","harborLocation":"Sydney Harbor"
  //     }] 
  

  ngOnInit(): void {

    
    this.http.get('http://localhost:9000/ftr/vehicles' ).subscribe(response => {
      if (response) {
        console.log('result of response:', response);

        // this.vehicles = response as any [];

        this.stringifiedData = JSON.stringify(response);
    console.log('result of sequqncecs:',this.stringifiedData);

    this.parsedJson = JSON.parse(this.stringifiedData);  
    console.log("With Parsed JSON :" , this.parsedJson['body']); 
    this.vehicles = this.parsedJson['body'] as any [];

      }

    }, (err: HttpErrorResponse) => {
      console.log('result of sequqncecs:', err['error']['message']);

    });

  }

}