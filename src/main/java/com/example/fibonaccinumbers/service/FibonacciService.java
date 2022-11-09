package com.example.fibonaccinumbers.service;

import org.springframework.stereotype.Service;

@Service
public class FibonacciService {

    public String getFibonacciNumbers(int number) {
        long[] numbers = new long[number];
        long temp;
        for (int i = 0; i <= numbers.length - 1; i++) {
            if (i <= 1) {
                numbers[i] = i;
            } else {
                numbers[i] = i - 1 + i - 2;
            }
        }
        return toString(numbers);
    }
    public String toString(long[] numbers) {
        StringBuilder sb = new StringBuilder();
        for (int i = numbers.length - 1; i >= 0; i--) {
            sb.append(numbers[i]).append(" ");
        }
        return sb.toString();
    }
}
