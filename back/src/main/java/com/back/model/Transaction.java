package com.back.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.back.enums.TransactionType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    @Getter
    @Column(name = "id_transaction")
    private Long idTransaction;

    @Setter
    @Getter
    @Column(name = "date")
    private LocalDate date;

    @Setter
    @Getter
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private TransactionType type;

    @Setter
    @Getter
    @Column(name = "amount")
    private BigDecimal amount;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id_category")
    private Category category;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "bank_code", referencedColumnName = "bank_code")
    private Bank bank_code;

}
