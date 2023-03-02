package com.slavamashkov.expensetracker.repository;

import com.slavamashkov.expensetracker.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
