package com.google.gson.internal;

import java.math.BigDecimal;

@SuppressWarnings("serial")
public final class LazilyParsedNumber extends Number {

    private final String value = null;

    private BigDecimal asBigDecimal() {
        throw new java.lang.Error();
    }

    public int intValue() {
        throw new java.lang.Error();
    }

    public long longValue() {
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            return asBigDecimal().longValue();
        }
    }

    public float floatValue() {
        throw new java.lang.Error();
    }

    public double doubleValue() {
        throw new java.lang.Error();
    }
}
