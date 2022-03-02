package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class dictionaryController {
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/")
    public String change(@RequestParam String word, Model model) {
        Map<String, String> diction = new HashMap<>();
        diction.put("hello", "Xin chào");
        diction.put("how", "Thế nào");
        diction.put("book", "Quyển vở");
        diction.put("computer", "Máy tính");
        String result = diction.get(word.trim());
        String message;
        if (result != null) {
            message = result;
        } else {
            message = "not found";
        }
//
//
        model.addAttribute("message", message);

        return "home";
    }
}
