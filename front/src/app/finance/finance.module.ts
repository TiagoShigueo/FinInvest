import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';
import { TransactionComponent } from './transaction/transaction.component';



@NgModule({
  declarations: [
    HomeComponent,
    TransactionComponent
  ],
  imports: [
    CommonModule
  ]
})
export class FinanceModule { }
