import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  standalone: false,
  styleUrl: './app.component.css',
})
export class AppComponent {
  isLoggedIn: boolean = false;
  constructor() {
    this.isLoggedIn = !!localStorage.getItem('authToken');
  }
  title = 'FinInvest';
}
