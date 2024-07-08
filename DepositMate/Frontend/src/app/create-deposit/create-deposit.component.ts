import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../auth.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './create-deposit.component.html',
  styleUrls: ['./create-deposit.component.css']
})
export class CreateDepositComponent {
  title(title: any) {
    throw new Error('Method not implemented.');
  }
  depositForm: FormGroup;
  result: string | null = null;

  constructor(private authService: AuthService, private fb: FormBuilder, private route: ActivatedRoute) {

    this.route.params.subscribe(params => {
      const data = JSON.parse(params['data']);
      // Use the data
      localStorage.setItem('userId', data);
      console.log(data);
      // const userId = data;
    });


    this.depositForm = this.fb.group({
      type: ['', Validators.required], 
      startDate: ['', Validators.required],
      amount: ['', [Validators.required, Validators.min(1)]],
      term: ['', [Validators.required, Validators.min(1)]]
    });
  }

  navigateToDashboard(){}

  
  handleDeposit(): void {
    if (this.depositForm.valid) {
      //const { type, startDate, amount, term } = this.depositForm.value;
      const userId = localStorage.getItem('userId');
      let typeLabel = '';
      let type = this.depositForm.value.type;
      let interest = 0;
      if (type === 'rd') {
        typeLabel = 'Recurrent Deposit';
        interest = 5;
      } else if (type === 'fd') {
        typeLabel = 'Fixed Deposit';
        interest = 6;
      } else if (type === 'cd') {
        typeLabel = 'Cumulative Deposit';
        interest = 7;
      }
      const depositData = {
        amount: this.depositForm.value.amount,
        noOfYears: this.depositForm.value.term,
        startDate: this.depositForm.value.startDate,
        depositType: typeLabel,
        interestRate: interest
      }
      this.result = `${typeLabel} Details:\nStart Date: ${depositData.startDate}\nAmount: ${depositData.amount}\nNumber of Years: ${depositData.noOfYears}\n`;
      this.depositForm.reset();


      this.authService.createDeposit(depositData, Number(userId)).subscribe(response => {
        console.log('Deposit created successfully', response);
        // Handle successful signup, e.g., navigate to login page or show a success message
        // this.router.navigate(['/login']);
        
      }, error => {
        // console.error('Signup failed:', error);
        // Handle error, e.g., show an error message
        alert('Error');
        //this.router.navigate(['/login']);
      });
    } else {
      console.log('Form is invalid');
      // Handle form validation errors
    }


      alert('Deposit Created Successfully')
  } 
}