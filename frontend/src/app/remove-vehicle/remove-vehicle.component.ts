import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-remove-vehicle',
  templateUrl: './remove-vehicle.component.html',
  styleUrls: ['./remove-vehicle.component.css']
})
export class RemoveVehicleComponent implements OnInit {

  showVehicles=false;
  loginForm : FormGroup;
  sucessMessage!:String;
  vehicleNumber!:String;

  constructor(private formBuilder: FormBuilder,private http: HttpClient) { 

      
    this.loginForm = this.formBuilder.group({
      
      vehicleNumber: [null, [Validators.required ]]
  
    });
  }

  ngOnInit(): void {
  }


  deleteVehicle() {

    this.showVehicles=true;

    //this.vehicleNumber = this.loginForm.controls.vehicleNumber.value
    console.log("vehicleNumber",this.vehicleNumber);
    this.http.delete('http://localhost:9000/ftr/vehicles/' + this.vehicleNumber).subscribe(response => {
      console.log('result of sequqncecs:',response);
      if (response) {
      //this.sucessMessage = response['message'];

      }

    }, (err: HttpErrorResponse) => {
      console.log('result of sequqncecs:', err['error']['message']);
      this.showVehicles = false;
      this.sucessMessage = err['error']['message'];

    });


  }

}
