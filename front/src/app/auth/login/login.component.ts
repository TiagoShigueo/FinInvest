import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
@Component({
  selector: 'app-login',
  standalone: false,

  templateUrl: './login.component.html',
})
export class LoginComponent {
  @ViewChild('formLogin') formLogin!: NgForm;
}
