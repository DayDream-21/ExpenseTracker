package com.slavamashkov.expensetracker.controller;

import com.slavamashkov.expensetracker.entity.Expense;
import com.slavamashkov.expensetracker.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class MainController {
    private final ExpenseService expenseService;

    @GetMapping
    public String showHomePage(Model model) {
        List<Expense> expenses = expenseService.findAll();

        model.addAttribute("expenses", expenses);

        return "home";
    }

    @GetMapping("/expense")
    public String openAddExpensePage(Model model) {
        model.addAttribute("expense", new Expense());

        return "expense";
    }

    @PostMapping(value = "/expense")
    public String save(@ModelAttribute("expense") Expense expense) {
        expenseService.save(expense);

        return "redirect:/";
    }

    @GetMapping("/expense/{id}")
    public String openEditExpensePage(@PathVariable String id, Model model) {
        Expense expense = expenseService.findById(Long.valueOf(id));

        model.addAttribute("expense", expense);

        return "expense";
    }

    @GetMapping("/expense/{id}/delete")
    public String deleteExpense(@PathVariable String id, Model model) {
        Expense expense = expenseService.findById(Long.valueOf(id));

        expenseService.delete(expense);

        return "redirect:/";
    }
}
