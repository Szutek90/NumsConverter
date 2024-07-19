package com.app.model;

import java.math.BigInteger;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NumberWithBase that = (NumberWithBase) o;
        return baseCode == that.baseCode && targetCode == that.targetCode && value == that.value;
    }

    @Override
    public int hashCode() {
        int result = baseCode;
        result = 31 * result + targetCode;
        result = 31 * result + value;
        return result;
    }

    @Override
    public String toString() {
        return "NumberWithBase{" +
                "baseCode=" + baseCode +
                ", targetCode=" + targetCode +
                ", value=" + value +
                '}';
    }

}
