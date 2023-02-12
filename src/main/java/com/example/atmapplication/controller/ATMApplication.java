package com.example.atmapplication.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class ATMApplication {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam("amount") double amount, Model model) {
        if (amount > 0) {
            // Գումարը հանելու համար զանգահարեք ծառայություն կամ պահեստ
            model.addAttribute("message", "Հաջող է դուրսբերումը!");
            log.info("Հաջող է դուրսբերումը");
        } else {
            model.addAttribute("message", "Անվավեր գումար!");
            log.error("Անվավեր գումար");
        }
        return "index";
    }
}
