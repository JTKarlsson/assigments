import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs'

@Injectable({
  providedIn: 'root'
})
export class HenkiloService {
  private apiUrl = 'http://localhost:8080/api'; // Replace with your API endpoint

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
    return this.http.get<any[]>(`${this.apiUrl}/henkilo`);
  }

  updateHenkilo(henkiloId: any, henkilo: any): Observable<any> {
    return this.http.put(`${this.apiUrl}/henkilo/${henkiloId}`, henkilo);
  }

  deleteHenkilo(henkiloId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/henkilo/${henkiloId}`);
  }
}
