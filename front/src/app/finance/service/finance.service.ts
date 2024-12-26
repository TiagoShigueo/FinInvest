import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, map, Observable, of, throwError } from 'rxjs';
import { Transaction } from '../../shared/models/transaction.model';
import { environment } from '../../../environments/environment.development';
import { LoginService } from '../../auth/services/login.service';

@Injectable({
  providedIn: 'root',
})
export class FinanceService {
  constructor(
    private httpClient: HttpClient,
    private loginService: LoginService
  ) {}

  private getHttpOptions() {
    const token = this.loginService.getToken();
    return {
      observe: 'response' as 'response',
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        ...(token ? { Authorization: `Bearer ${token}` } : {}),
      }),
    };
  }

  getAllTransactions(): Observable<Transaction[] | null> {
    const httpOptions = this.getHttpOptions();
    return this.httpClient
      .get<Transaction[]>(environment.apiUrl + '/transaction', httpOptions)
      .pipe(
        map((resp: HttpResponse<Transaction[]>) => {
          if (resp.status == 200 && resp.body != null) {
            // resp.body.map((p) => {
            // conversor da data aqui ou fazer de outra alternativa
            // });
            return resp.body;
          } else {
            return null;
          }
        }),
        catchError((err, caught) => {
          if (err.status == 400) {
            return of(null);
          } else {
            return throwError(() => err);
          }
        })
      );
  }
}
