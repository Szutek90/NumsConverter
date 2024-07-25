package com.app.file_operator.impl;

import com.app.service.Converter;
import com.app.service.impl.ToListConverter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumsFileOperatorTest {
    static NumsFileOperator fileOperator;
    static Converter<String> converter;

    @BeforeAll
    static void beforeAll() {
        fileOperator = new NumsFileOperator("src/test/resources/testFile1.csv",
                "src/test/resources/testFile2.csv", "src/test/resources/testSameCodes.csv");
        converter = new ToListConverter(fileOperator.readFile());
    }

    @Test
    @DisplayName("When writing file")
    void test1() {
        Assertions.assertThatCode(() -> fileOperator.writeFile(converter.convert()))
                .doesNotThrowAnyException();
    }
}
