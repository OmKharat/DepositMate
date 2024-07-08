// import { Component } from '@angular/core';
// import { NgForm } from '@angular/forms';


// @Component({
//   selector: 'app-signup',
//   templateUrl: './signup.component.html',
//   styleUrls: ['./signup.component.css']
// })
// export class SignupComponent {
//   signupForm: any = {};

//   constructor() {}

//   onSignup(form: NgForm) {
    
//     console.log(form.value); 
//   }

//   openLogin() {
    
//     console.log('Opening login');
//   }
// }


import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService } from '../auth.service'; // Import the AuthService
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  // signupForm: any = {};

  username: string = '';
  age: number = 0;
  gender: string = '';
  phonenumber: string = '';
  email: string = '';
  aadhar: string = '';
  password: string = '';

  constructor(private authService: AuthService, private router: Router) {} // Inject AuthService

  onSignup(form: NgForm) {
    if (form.valid) {
      const userData = {
        username: this.username,
        age: this.age,
        gender: this.gender,
        phonenumber: this.phonenumber,
        email: this.email,
        aadhar: this.aadhar,
        password: this.password
      };
      
      this.authService.signup(userData).subscribe(response => {
        console.log('Signup successful:', response);
        // Handle successful signup, e.g., navigate to login page or show a success message
        this.router.navigate(['/login']);
        
      }, error => {
        console.error('Signup failed:', error);
        // Handle error, e.g., show an error message
        alert("Signup successfull");
        this.router.navigate(['/login']);
      });
    } else {
      console.log('Form is invalid');
      // Handle form validation errors
    }
  }

  openLogin() {
    console.log('Opening login');
  }
}
