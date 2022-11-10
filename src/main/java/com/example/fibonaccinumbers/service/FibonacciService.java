package com.example.fibonaccinumbers.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class FibonacciService {

    public List<String> getFibonacciRows(String[] rows) {
        log.info(String.format("Input data: %s", Arrays.toString(rows)));

        List<Integer> fibNumbers = new ArrayList<>(Arrays.asList(getFirstTenFibonacciNumbers()));
        List<String> fibRows = new ArrayList<>();

        for (int i = 0; i < rows.length; i++) {
            if (fibNumbers.contains(i + 1)) {
                fibRows.add(reverse(rows[i]));
            }
        }
        log.info("Load data to file");
        saveInFile(fibRows);
        log.info(String.format("Reversed rows: %s", fibRows));
        return fibRows;
    }

    private Integer[] getFirstTenFibonacciNumbers() {
        Integer[] numbers = new Integer[10];

        for (int i = 0; i <= numbers.length - 1; i++) {
            if (i <= 1) {
                numbers[i] = i;
            } else {
                numbers[i] = numbers[i - 1] + numbers[i - 2];
            }
        }
        return numbers;
    }

    private String reverse(String row) {
        StringBuilder reverseRow = new StringBuilder();

        for (int i = row.length() - 1; i >= 0; i--) {
            reverseRow.append(row.charAt(i));
        }

        return reverseRow.toString();
    }

    private void saveInFile(List<String> row) {
        File file = new File("Result.txt");
        log.info(String.format("Create file with name: %s", file.getName()));
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            log.info("Write data in file");
            writer.write(row.toString());
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            log.error("Error appeared while loading data to file");
            ex.printStackTrace();
        }
    }
}
