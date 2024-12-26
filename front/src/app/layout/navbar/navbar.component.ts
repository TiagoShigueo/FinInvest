import { Component } from '@angular/core';
import { LoginService } from '../../auth/services/login.service';

@Component({
  selector: 'app-navbar',
  standalone: false,

  templateUrl: './navbar.component.html',
})
export class NavbarComponent {
  constructor(private loginService: LoginService) {}
  onLogout() {
    this.loginService.logout();
  }
}
