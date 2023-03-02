package com.slavamashkov.expensetracker.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("/home")
public class Controller {
    @GetMapping
    public String showHomePage(Model model) {
        List<String> strings = List.of("ABC", "DEF", "GHI");
        model.addAttribute("strings", strings);
        return "home";
    }
}
