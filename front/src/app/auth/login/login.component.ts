import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-login',
  standalone: false,

  templateUrl: './login.component.html',
})
export class LoginComponent {
  loginForm: FormGroup;
  message!: String;

  constructor(private loginService: LoginService, private fb: FormBuilder) {
    this.loginForm = this.fb.group({
      login: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(2)]],
    });
    console.log(localStorage);
  }

  onSubmit() {
    if (this.loginForm.valid) {
      this.loginService.login(this.loginForm.value).subscribe({
        next: (usu) => {
          if (usu == null) {
            this.message = 'Usuário/senha inválido!';
          }
        },
        error: (err) => {
          this.message = `Erro efetuando login ${err.message}`;
        },
      });
    }
  }
}
