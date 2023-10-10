import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs'

@Injectable({
  providedIn: 'root'
})
export class HenkiloService {
  // public for tests... maybe should use getter.. but not this time!
  public apiUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  createHenkilo(henkilo: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/henkilo`, henkilo)
      .pipe(
        catchError(error => {
          console.error('Error creating Henkilo:', error);
          return throwError(() => error);
        })
      );
  }

  getHenkilo(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/henkilo`)
      .pipe(
        catchError(error => {
          console.error('Error getting HenkiloList:', error);
          return throwError(() => error);
        })
      );
  }

  updateHenkilo(henkiloId: any, henkilo: any): Observable<any> {
    return this.http.put(`${this.apiUrl}/henkilo/${henkiloId}`, henkilo)
      .pipe(
        catchError(error => {
          console.error('Error updating Henkilo:', error);
          return throwError(() => error);
        })
      );
  }

  deleteHenkilo(henkiloId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/henkilo/${henkiloId}`)
      .pipe(
        catchError(error => {
          console.error('Error deleting Henkilo:', error);
          return throwError(() => error);
        })
      );
  }
}
