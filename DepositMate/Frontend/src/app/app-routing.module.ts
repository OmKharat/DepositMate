import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { CalculateInterestComponent } from './calculateinterest/calculateinterest.component';
import { CreateDepositComponent } from './create-deposit/create-deposit.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AdminComponent } from './admin/admin.component';

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'create-deposit', component: CreateDepositComponent },
  { path: 'calculate-interest', component: CalculateInterestComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'admin-dashboard', component: AdminComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
