// import { Component } from '@angular/core';
// dashboard.component.ts
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css'
})
export class AdminComponent {

  constructor(private http: HttpClient, private router: Router, private route: ActivatedRoute){}

  deposits: any[] = [];

  ngOnInit() {
    this.fetchDeposits();
  }
  fetchDeposits() {
    const userId = localStorage.getItem('userId');
    console.log(userId);
    this.http.get(`http://localhost:8085/api/deposits/all`).subscribe((data: any) => {
      this.deposits = data.map((item: any) => ({
        userid: item.userID.userid,
        username: item.userID.username,
        amount: item.amount,
        noofYears: item.noOfYears,
        startDate: item.startDate,
        maturityDate: item.maturityDate,
        depositType: item.depositType,
        interestRate: item.interestRate,
        depositId: item.depositId
      }));
    });
  }

  calculateRDInterest(amount: number, term: number): number {
    const rate = 0.05;
    const interest = amount * term * rate;
    return interest;
  }

  calculateFDInterest(amount: number, term: number): number {
    const rate = 0.06; // 6% per year
    const interest = amount * (term) * rate;
    return interest;
  }

  calculateCumulativeInterest(amount: number, term: number): number {
    const rate = 0.07; // 7% per year
    const interest = amount * Math.pow(1 + rate, term) - amount;
    return interest;
  }

  calculateInterest(deposit: any): number {
    
    let interest = 0;
    if(deposit.depositType == 'Fixed Deposit') interest = this.calculateFDInterest(deposit.amount, deposit.noofYears);
    else if(deposit.depositType == 'Recurrent Deposit') interest = this.calculateRDInterest(deposit.amount, deposit.noofYears);
    else interest = this.calculateCumulativeInterest(deposit.amount, deposit.noofYears);
    return Math.round(interest*100)/100;
    // return parseFloat((Math.round(deposit.amount * Math.pow(1 + interestRate, deposit.noofYears) - deposit.amount)).toFixed(2));
  }

}
