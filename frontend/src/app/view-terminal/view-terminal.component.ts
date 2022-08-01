import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Terminal } from '../add-terminal/Terminal';
import { TerminalService } from '../terminal.service';

@Component({
  selector: 'app-view-terminal',
  templateUrl: './view-terminal.component.html',
  styleUrls: ['./view-terminal.component.css']
})
export class ViewTerminalComponent implements OnInit {

  terminalId !: String;
  terminal !: Terminal;
  loading = true;
  modal = false;
  error = false;
  errorMessage = "No such terminal Found";
  constructor(private terminalService:TerminalService,private route:ActivatedRoute,private router:Router) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe((params:any) => {
      this.terminalId = params.get("id");
      this.terminalService.getTerminalById(this.terminalId).subscribe({
        next: (data:Terminal) => {
          this.terminal = data;
          this.loading = false;
        },
        error: (e:any) => {
          this.loading = false;
          this.error = true;
          this.errorMessage = e;
        }
      });
      });
   
  }

  goToDetails()
  {
    this.router.navigate(['admin/dashboard/terminal']);
  }

  deleteTerminal()
  {
    this.terminalService.deleteTerminal(this.terminalId).subscribe({
      next: (data:any) => {
        this.modal = false;
        this.router.navigate(['admin/dashboard/terminal']);
      },
      error: (e:any) => console.error(e)
    });
  }

}
