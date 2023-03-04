package com.slavamashkov.expensetracker.service;

import com.slavamashkov.expensetracker.entity.Expense;

import java.util.List;

public interface ExpenseService {
    List<Expense> findAll();

    void save(Expense expense);

    void delete(Expense expense);

    Expense findById(Long id);
}
