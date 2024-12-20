import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment.development';
import { HttpHeaders, HttpClient, HttpResponse } from '@angular/common/http';
import { Auth } from '../../shared/models/auth.model';
import { LoginResponseDTO } from '../../shared/models/login-response-dto.model';
import { catchError, map, Observable, of, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class LoginServiceService {
  httpOptions = {
    observe: 'response' as 'response',
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };

  constructor(private httpClient: HttpClient) {}

  login(auth: Auth): Observable<LoginResponseDTO | null> {
    return this.httpClient
      .post<LoginResponseDTO>(
        environment.apiUrl + '/auth/login',
        JSON.stringify(auth),
        this.httpOptions
      )
      .pipe(
        map((resp: HttpResponse<LoginResponseDTO>) => {
          if (resp.status == 200) {
            console.log(resp.body);
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
}
