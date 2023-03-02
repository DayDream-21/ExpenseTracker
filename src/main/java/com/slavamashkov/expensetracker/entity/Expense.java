package com.slavamashkov.expensetracker.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Table(name = "expense")
@Getter
@Setter
@ToString
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String expenseName;

    private BigDecimal amount;

    private String note;

    @Column(name = "created_at")
    private Long createdAt;
}
