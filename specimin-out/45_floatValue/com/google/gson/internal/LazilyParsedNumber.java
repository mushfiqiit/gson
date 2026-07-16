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
        return Float.parseFloat(value);
    }

    public double doubleValue() {
        throw new java.lang.Error();
    }
}
