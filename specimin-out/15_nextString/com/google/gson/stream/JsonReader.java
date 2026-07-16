package com.google.gson.stream;

import java.io.IOException;

public class JsonReader {

    private static final int PEEKED_NONE = 0;

    private static final int PEEKED_SINGLE_QUOTED = 0;

    private static final int PEEKED_DOUBLE_QUOTED = 0;

    private static final int PEEKED_UNQUOTED = 0;

    private static final int PEEKED_BUFFERED = 0;

    private static final int PEEKED_LONG = 0;

    private static final int PEEKED_NUMBER = 0;

    private final char[] buffer = null;

    private int pos;

    int peeked;

    private long peekedLong;

    private int peekedNumberLength;

    private String peekedString;

    private int stackSize;

    private int[] pathIndices;

    @SuppressWarnings("fallthrough")
    int doPeek() throws IOException {
        throw new java.lang.Error();
    }

    public String nextString() throws IOException {
        int p = peeked;
        if (p == PEEKED_NONE) {
            p = doPeek();
        }
        String result;
        if (p == PEEKED_UNQUOTED) {
            result = nextUnquotedValue();
        } else if (p == PEEKED_SINGLE_QUOTED) {
            result = nextQuotedValue('\'');
        } else if (p == PEEKED_DOUBLE_QUOTED) {
            result = nextQuotedValue('"');
        } else if (p == PEEKED_BUFFERED) {
            result = peekedString;
            peekedString = null;
        } else if (p == PEEKED_LONG) {
            result = Long.toString(peekedLong);
        } else if (p == PEEKED_NUMBER) {
            result = new String(buffer, pos, peekedNumberLength);
            pos += peekedNumberLength;
        } else {
            throw unexpectedTokenError("a string");
        }
        peeked = PEEKED_NONE;
        pathIndices[stackSize - 1]++;
        return result;
    }

    private String nextQuotedValue(char quote) throws IOException {
        throw new java.lang.Error();
    }

    @SuppressWarnings("fallthrough")
    private String nextUnquotedValue() throws IOException {
        throw new java.lang.Error();
    }

    public void close() throws IOException {
        throw new java.lang.Error();
    }

    private IllegalStateException unexpectedTokenError(String expected) throws IOException {
        throw new java.lang.Error();
    }
}
