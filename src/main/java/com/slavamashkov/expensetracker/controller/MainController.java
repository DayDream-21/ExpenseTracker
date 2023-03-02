package com.slavamashkov.expensetracker.controller;

import com.slavamashkov.expensetracker.entity.Expense;
import com.slavamashkov.expensetracker.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String addExpense(Model model) {
        model.addAttribute("expense", new Expense());

        return "expense";
    }

    @PostMapping(value = "/expense")
    public String save(@ModelAttribute("expense") Expense expense) {
        expenseService.save(expense);
        return "redirect:/";
    }
}
