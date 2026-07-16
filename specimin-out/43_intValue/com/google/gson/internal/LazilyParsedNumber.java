package com.google.gson.internal;

import java.math.BigDecimal;

@SuppressWarnings("serial")
public final class LazilyParsedNumber extends Number {

    private final String value = null;

    private BigDecimal asBigDecimal() {
        throw new java.lang.Error();
    }

    public int intValue() {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            try {
                return (int) Long.parseLong(value);
            } catch (NumberFormatException nfe) {
                return asBigDecimal().intValue();
            }
        }
    }

    public long longValue() {
        throw new java.lang.Error();
    }

    public float floatValue() {
        throw new java.lang.Error();
    }

    public double doubleValue() {
        throw new java.lang.Error();
    }
}
