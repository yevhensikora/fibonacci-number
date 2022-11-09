package com.example.fibonaccinumbers.controller;

import com.example.fibonaccinumbers.service.FibonacciService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/fibonacci-numbers")
@RestController
public class FibonacciController {

    private final FibonacciService fibonacciService;

    public FibonacciController(FibonacciService fibonacciService) {
        this.fibonacciService = fibonacciService;
    }

    @GetMapping("/{number}")
    public String getFibonacciNumbers(@PathVariable int number) {
        return fibonacciService.getFibonacciNumbers(number);
    }
}
