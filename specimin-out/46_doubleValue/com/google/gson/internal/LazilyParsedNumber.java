package com.google.gson.internal;

@SuppressWarnings("serial")
public final class LazilyParsedNumber extends Number {

    private final String value = null;

    public int intValue() {
        throw new java.lang.Error();
    }

    public long longValue() {
        throw new java.lang.Error();
    }

    public float floatValue() {
        throw new java.lang.Error();
    }

    public double doubleValue() {
        return Double.parseDouble(value);
    }
}
