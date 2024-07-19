package com.app.file_operator.impl;

import com.app.file_operator.FileOperator;
import com.app.model.NumberWithBase;
import lombok.RequiredArgsConstructor;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class NumsFileOperator implements FileOperator<String> {

    private final String inFileName;

    private final String outFileName;
    private final String sameCodesFileName;


    public List<NumberWithBase> readFile() {
        try (var lines = Files.lines(Paths.get(inFileName))) {
            var numbers = lines
                    .map(NumberWithBase::parse)
                    .collect(Collectors.toCollection(LinkedList::new));
            var numbersWithTheSameCodes = numbers
                    .stream()
                    .filter(NumberWithBase::codingIsTheSame)
                    .map(NumberWithBase::format)
                    .toList();
            writeFile(numbersWithTheSameCodes, sameCodesFileName);
            return numbers;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public void writeFile(List<String> data) {
        writeFile(data, outFileName);
    }

    private void writeFile(List<String> data, String fileName) {
        try {
            Files.write(Paths.get(fileName), data);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

}
