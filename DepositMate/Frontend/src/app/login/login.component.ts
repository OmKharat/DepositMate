// import { Component } from '@angular/core';
// import { AuthService } from '../auth.service';
// import { P } from '@angular/cdk/keycodes';

// @Component({
//   selector: 'app-login',
//   templateUrl: './login.component.html',
//   styleUrls: ['./login.component.css']
// })
// // export class LoginComponent {
// //   email: string;
// //   password: string;
// //   constructor() {}

// //   openSignup() {
// //     console.log('Opening signup');
// //   }
// // }

// export class LoginComponent {
//   // email!: string;
//   // password!: string;

//   constructor(private authService: AuthService) {}

//   login(email : string, password: string) {
//     const credentials = { email: email, password: password };
//     this.authService.login(credentials).subscribe(response => {
//       // Handle response, e.g., store token, navigate to dashboard, etc.
//       console.log("Login Success", response);
//     }, error => {
//       // Handle error
//       console.log("Login failed", error);
//     });
//   }
// }

import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  email: string = '';
  password: string = '';

  //loginForm: any = {};

  constructor(private authService: AuthService, private router: Router) {}

  login(form: NgForm) {
    // console.log(form);
    if (form.valid) {
      const credentials = { email: this.email, password: this.password };
      
      this.authService.login(credentials).subscribe(response => {
        console.log('Login successful:', response);
        if(response.status){
          if(credentials.email == 'admin@email.com') this.router.navigate(['/admin-dashboard']);
          else this.router.navigate(['/dashboard',{ data: JSON.stringify(response.userid) }]);
        }
        else{
          alert('Error: Invalid Credentials');
        }
        // Handle successful login, e.g., store token, navigate to dashboard, etc.
      }, error => {
        console.error('Login failed:', error);
        alert('Error: Invalid Credentials');
        // Handle error, e.g., show an error message
      });
    } else {
      console.log('Form is invalid');
      // Handle form validation errors
    }
  }
}
