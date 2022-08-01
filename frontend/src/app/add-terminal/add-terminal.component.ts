import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { TerminalService } from '../terminal.service';

import { Terminal } from './Terminal';

@Component({
  selector: 'app-add-terminal',
  templateUrl: './add-terminal.component.html',
  styleUrls: ['./add-terminal.component.css']
})
export class AddTerminalComponent implements OnInit {

  addTerminalForm !:FormGroup;
  constructor(private formBuilder: FormBuilder,private terminalService:TerminalService,private router:Router) { }

  ngOnInit(): void {
    this.addTerminalForm = this.formBuilder.group({
      terminalName: ['', [Validators.required,validateLength]],
      country: ['', [Validators.required,validateLength]],
      itemType: ['', [Validators.required,validateLength2]],
      terminalDescription: ['', [Validators.required]],
      capacity: [0, [Validators.required]],
      status: ['', [Validators.required]],
      harborLocation: ['', [Validators.required]],
      availableCapacity: [0, [Validators.required]],
      
    });
  }

  onSubmit(){
    this.terminalService.addTerminal(this.addTerminalForm.value).subscribe({
      next: (data:Object) => {
          this.router.navigate(['admin/dashboard/terminal']);
      },
      error: (e : any) => {
        alert(e);
      }
    });
  }

  goToDetails(){
    this.router.navigate(['admin/dashboard/terminal'])
  }
 
}

function  validateLength(c: FormControl): any {
  return (c.value.length >= 3 && c.value.length <= 20) ? null : {
    lengthInvalid: {
      message : "This field length must be between 3 and 20"
    }
  };
}

function  validateLength2(c: FormControl): any {
  return (c.value.length >= 4 && c.value.length <= 30) ? null : {
    lengthInvalid: {
      message : "This field length must be between 4 and 30"
    }
  };
}


