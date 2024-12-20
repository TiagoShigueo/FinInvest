import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment.development';
import { HttpHeaders, HttpClient, HttpResponse } from '@angular/common/http';
import { Auth } from '../../shared/models/auth.model';
import { LoginResponseDTO } from '../../shared/models/login-response-dto.model';
import { catchError, map, Observable, of, throwError } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  httpOptions = {
    observe: 'response' as 'response',
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };

  token!: string | undefined;
  constructor(private httpClient: HttpClient, private router: Router) {}

  login(auth: Auth): Observable<LoginResponseDTO | null> {
    console.log(auth);
    return this.httpClient
      .post<LoginResponseDTO>(
        environment.apiUrl + '/auth/login',
        JSON.stringify(auth),
        this.httpOptions
      )
      .pipe(
        map((resp: HttpResponse<LoginResponseDTO>) => {
          if (resp.status == 200) {
            this.token = resp.body?.token.toString();
            if (this.token) {
              localStorage.setItem('authToken', this.token);
            }
            this.router.navigate(['/finance/home']);
            return resp.body;
          } else {
            return null;
          }
        }),
        catchError((err) => {
          if (err.status == 401) {
            return of(null);
          } else {
            return throwError(() => err);
          }
        })
      );
  }

  logout(): void {
    localStorage.removeItem('authToken');
    this.router.navigate(['']);
  }
}
