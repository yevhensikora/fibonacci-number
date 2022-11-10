package com.example.fibonaccinumbers.controller;

import com.example.fibonaccinumbers.model.Request;
import com.example.fibonaccinumbers.service.FibonacciService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class FibonacciController {

    private final FibonacciService fibonacciService;

    @GetMapping("/fibonacci-rows")
    public List<String> getFibonacciRows(@RequestBody Request request) {
        return fibonacciService.getFibonacciRows(request.getRows());
    }

}
