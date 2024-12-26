import { TransactionType } from '../enums/transaction-type';
import { Bank } from './bank.model';
import { Category } from './category.model';

export class Transaction {
  constructor(
    public id: number,
    public date: string,
    public type: TransactionType,
    public amount: number,
    public category: Category,
    public bank_code: Bank
  ) {}
}
