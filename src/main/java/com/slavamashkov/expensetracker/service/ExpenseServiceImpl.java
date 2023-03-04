package com.slavamashkov.expensetracker.service;

import com.slavamashkov.expensetracker.entity.Expense;
import com.slavamashkov.expensetracker.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {
    private final ExpenseRepository expenseRepository;

    @Override
    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }

    @Override
    public void save(Expense expense) {
        if (expense.getId() == null) {
            expense.setCreatedAt(System.currentTimeMillis());
        } else {
            expense.setCreatedAt(expenseRepository.findById(expense.getId()).get().getCreatedAt());
        }

        expenseRepository.save(expense);
    }

    @Override
    public void delete(Expense expense) {
        expenseRepository.delete(expense);
    }

    @Override
    public Expense findById(Long id) {
        return expenseRepository.findById(id).orElse(null);
    }
}
