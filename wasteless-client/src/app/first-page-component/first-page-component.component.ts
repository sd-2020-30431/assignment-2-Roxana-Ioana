import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-first-page-component',
  templateUrl: './first-page-component.component.html',
  styleUrls: ['./first-page-component.component.css']
})
export class FirstPageComponentComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  goToLogin() {
    this.router.navigate(['/login']);
  }
}
