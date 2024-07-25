package com.app.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigInteger;

@EqualsAndHashCode
@ToString
public class NumberWithBase {
    private final int baseCode;
    private final int targetCode;
    private final int value;

    public NumberWithBase(int baseCode, int targetCode, int value) {
        this.baseCode = baseCode;
        this.targetCode = targetCode;
        this.value = value;
    }

    public String format() {
        return String.format("%d %d %d", baseCode, targetCode, value);
    }

    public static NumberWithBase parse(String input) {
        var parts = input.split(" ");
        return new NumberWithBase(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]),
                Integer.parseInt(parts[2]));
    }

    public boolean codingIsTheSame() {
        return baseCode == targetCode;
    }

    public String codeToTargetCode() {
        return new BigInteger(String.valueOf(value), baseCode).toString(targetCode).toUpperCase();
    }

}
