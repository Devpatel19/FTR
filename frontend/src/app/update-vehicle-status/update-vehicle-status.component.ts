import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';



@Component({
  selector: 'app-update-vehicle-status',
  templateUrl: './update-vehicle-status.component.html',
  styleUrls: ['./update-vehicle-status.component.css']
})
export class UpdateVehicleStatusComponent implements OnInit {

  

 
  loginForm!: FormGroup;
  showVehicles=false;
  sucessMessage!: String;
  failureMessage!:String;
  vehicleNumber!: String;
  categories: any[] = [

    { id: 1, name: 'Active', value: 'Active' },
    { id: 2, name: 'Retired', value: 'Retired' },
    { id: 3, name: 'InProgress', value: 'InProgress' }

  ];
  constructor(private http: HttpClient, private formBuilder: FormBuilder) { 

    this.loginForm = this.formBuilder.group({

      update_template: ['', Validators.required],
      vehicleNumber: ['', Validators.required]
    });
  }
  ngOnInit(): void {
  }
  updateStatus() {

    this.showVehicles=true;
    console.log(this.loginForm.controls['update_template'].value)
    console.log(this.loginForm.controls['vehicleNumber'].value)

    let updateObject = {
        'vehicleStatus': this.loginForm.controls['update_template'].value
      };

      console.log("UpdateObject",updateObject)
      this.vehicleNumber=this.loginForm.controls['vehicleNumber'].value
      this.http.put(' http://localhost:9000/ftr/vehicles/' + this.vehicleNumber, updateObject).subscribe(response => {
      if (response) {
        console.log('result of response:', response);
        //this.sucessMessage=response;

      }

    }, (err: HttpErrorResponse) => {
      console.log('result of sequqncecs:', err['error']['message']);
      console.log('result of sequqncecs:', err['error']['text']);
      this.sucessMessage=err['error']['text'];
      this.failureMessage=err['error']['message'];

    });
}
}


