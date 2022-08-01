import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Terminal } from '../add-terminal/Terminal';
import { TerminalService } from '../terminal.service';

@Component({
  selector: 'app-terminal-details',
  templateUrl: './terminal-details.component.html',
  styleUrls: ['./terminal-details.component.css']
})
export class TerminalDetailsComponent implements OnInit {

  terminals !: Terminal[];
  filteredTerminals !: Terminal[];
  loading = true;
  itemType !: String;
  error = false;
  errorMessage = "No such Terminals Found !!";
  constructor(private terminalService: TerminalService, private router: Router) { }

  ngOnInit(): void {
    this.terminalService.getAllTerminals().subscribe({
      next: (data: Terminal[]) => {

        this.terminals = data;
        this.filteredTerminals = data;
        this.loading = false;
      },
      error: (e: any) => {
        this.error = true;
        this.loading = false;
        this.errorMessage = e;
      }
    });

  }

  goToAdd() {
    this.router.navigate(['/addterminal'])
  }

  viewTerminal(terminalId: String) {
    this.router.navigate(['/terminal/' + terminalId]);

  }

  searchByItemType() {
    if (this.itemType != '' && this.itemType != undefined) {
      let tempTerminals = this.filteredTerminals.filter((item) => item.itemType == this.itemType);
      if (tempTerminals.length > 0) {
        this.error = false;
        this.filteredTerminals = tempTerminals;
      }
      else {
        this.error = true;
      }
    }
    else {
      this.error = false;
      this.filteredTerminals = this.terminals;
    }
  }

  setTerminals() {
    if (this.itemType == '' || this.itemType == undefined) {
      this.error = false;
      this.filteredTerminals = this.terminals;
    }
  }
}
