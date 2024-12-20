import { Component } from '@angular/core';
import { LoginService } from '../../auth/services/login.service';

@Component({
  selector: 'app-home',
  standalone: false,

  templateUrl: './home.component.html',
})
export class HomeComponent {
  constructor(private loginService: LoginService) {
    console.log(localStorage);
  }
  onLogout() {
    this.loginService.logout();
  }
}
