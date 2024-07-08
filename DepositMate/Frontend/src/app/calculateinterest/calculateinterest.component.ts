import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './calculateinterest.component.html',
  styleUrls: ['./calculateinterest.component.css']
})
export class CalculateInterestComponent implements OnInit {
  title = 'deposit';
  rdForm: FormGroup;
  fdForm: FormGroup;
  cumulativeForm: FormGroup;
  result: string | null = null;

  constructor(private fb: FormBuilder) {
    this.rdForm = this.fb.group({
      amount: ['', [Validators.required, Validators.min(1)]],
      term: ['', [Validators.required, Validators.min(1)]]
    });

    this.fdForm = this.fb.group({
      amount: ['', [Validators.required, Validators.min(1)]],
      term: ['', [Validators.required, Validators.min(1)]]
    });

    this.cumulativeForm = this.fb.group({
      amount: ['', [Validators.required, Validators.min(1)]],
      term: ['', [Validators.required, Validators.min(1)]]
    });
  }

  ngOnInit(): void {}

  handleRD(): void {
    if (this.rdForm.valid) {
      const { amount, term } = this.rdForm.value;
      const interest = this.calculateRDInterest(amount, term);
      this.result = `Recurrent Deposit Details:\nMonthly Amount: ${amount}\nTerm: ${term} months\nEstimated Interest: ${interest.toFixed(2)}`;
      this.rdForm.reset();
    } else {
      alert('Please enter valid amounts.');
    }
  }

  handleFD(): void {
    if (this.fdForm.valid) {
      const { amount, term } = this.fdForm.value;
      const interest = this.calculateFDInterest(amount, term);
      this.result = `Fixed Deposit Details:\nAmount: ${amount}\nTerm: ${term} months\nEstimated Interest: ${interest.toFixed(2)}`;
      this.fdForm.reset();
    } else {
      alert('Please enter valid amounts.');
    }
  }

  handleCumulative(): void {
    if (this.cumulativeForm.valid) {
      const { amount, term } = this.cumulativeForm.value;
      const interest = this.calculateCumulativeInterest(amount, term);
      this.result = `Cumulative Deposit Details:\nAmount: ${amount}\nTerm: ${term} months\nEstimated Interest: ${interest.toFixed(2)}`;
      this.cumulativeForm.reset();
    } else {
      alert('Please enter valid amounts.');
    }
  }

  calculateRDInterest(amount: number, term: number): number {
    const rate = 0.05;
    const interest = amount * term * rate;
    return interest;
  }

  calculateFDInterest(amount: number, term: number): number {
    const rate = 0.06; // 6% per year
    const interest = amount * (term / 12) * rate;
    return interest;
  }

  calculateCumulativeInterest(amount: number, term: number): number {
    const rate = 0.07; // 7% per year
    const interest = amount * Math.pow(1 + rate, term / 12) - amount;
    return interest;
  }
  navigateToDashboard(){}
  createDeposit(): void {
    // Implement your create deposit logic here
    //alert('Create Deposit button clicked!');
  }
}
