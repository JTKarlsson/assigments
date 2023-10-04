import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs'

@Injectable({
  providedIn: 'root'
})
export class HenkiloService {
  private apiUrl = 'http://localhost:8080/api'; // Replace with your API endpoint

  constructor(private http: HttpClient) {}

  // Create
  createItem(item: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/items`, item);
  }

  // Read
  getItems(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/henkilot`);
  }

  // Update
  updateItem(item: any): Observable<any> {
    return this.http.put(`${this.apiUrl}/items/${item.id}`, item);
  }

  // Delete
  deleteItem(itemId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/items/${itemId}`);
  }
}
