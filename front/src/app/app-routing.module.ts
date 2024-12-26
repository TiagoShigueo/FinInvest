import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { HomeComponent } from './finance/home/home.component';
import { AuthGuard } from './auth/auth.guard';
import { TransactionComponent } from './finance/transaction/transaction.component';

const routes: Routes = [
  {
    path: '',
    component: LoginComponent,
  },
  {
    path: 'finance/home',
    component: HomeComponent,
    canActivate: [AuthGuard],
  },
  {
    path: 'finance/transaction',
    component: TransactionComponent,
    canActivate: [AuthGuard],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
