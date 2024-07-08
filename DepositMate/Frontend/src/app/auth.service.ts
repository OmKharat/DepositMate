import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private baseUrl = 'http://localhost:8085/api'; // Spring Boot backend URL

  constructor(private http: HttpClient) {}

  login(credentials: { email: string, password: string }): Observable<any> {
    return this.http.post(`${this.baseUrl}/user/login`, credentials);
  }

  signup(userData: { username: string, age: number, gender: string, phonenumber: string, email: string, aadhar: string, password: string }): Observable<any> {
    return this.http.post(`${this.baseUrl}/user/save`, userData);
  }

  createDeposit(depositData: { amount: number, noOfYears: number, startDate: Date, depositType: string, interestRate: number }, userid: number): Observable<any> {
    return this.http.post(`${this.baseUrl}/deposits/${userid}/create`, depositData);
  }
}
