package com.back.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "banks")
public class Bank {
    @Id
    @Setter
    @Getter
    @Column(name = "bank_code")
    private Integer code;

    @Setter
    @Getter
    @Column(name = "name")
    private String name;
}
