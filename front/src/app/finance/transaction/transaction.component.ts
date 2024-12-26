import { Component, OnInit } from '@angular/core';
import { Transaction } from '../../shared/models/transaction.model';
import { FinanceService } from '../service/finance.service';

@Component({
  selector: 'app-transaction',
  standalone: false,

  templateUrl: './transaction.component.html',
  styleUrl: './transaction.component.css',
})
export class TransactionComponent implements OnInit {
  transactions: Transaction[] = [];

  constructor(private financeService: FinanceService) {}
  ngOnInit(): void {
    this.loadTransaction();
  }
  loadTransaction(): Transaction[] {
    this.financeService.getAllTransactions().subscribe({
      next: (data: Transaction[] | null) => {
        if (data == null) {
          this.transactions = [];
        } else {
          this.transactions = data;
          console.log(this.transactions);
        }
      },
    });
    return this.transactions;
  }
}
