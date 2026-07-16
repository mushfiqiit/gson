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

    private String nextQuotedValue(char quote) throws IOException {
        throw new java.lang.Error();
    }

    @SuppressWarnings("fallthrough")
    private String nextUnquotedValue() throws IOException {
        throw new java.lang.Error();
    }

    public int nextInt() throws IOException {
        int p = peeked;
        if (p == PEEKED_NONE) {
            p = doPeek();
        }
        int result;
        if (p == PEEKED_LONG) {
            result = (int) peekedLong;
            if (peekedLong != result) {
                throw new NumberFormatException("Expected an int but was " + peekedLong + locationString());
            }
            peeked = PEEKED_NONE;
            pathIndices[stackSize - 1]++;
            return result;
        }
        if (p == PEEKED_NUMBER) {
            peekedString = new String(buffer, pos, peekedNumberLength);
            pos += peekedNumberLength;
        } else if (p == PEEKED_SINGLE_QUOTED || p == PEEKED_DOUBLE_QUOTED || p == PEEKED_UNQUOTED) {
            if (p == PEEKED_UNQUOTED) {
                peekedString = nextUnquotedValue();
            } else {
                peekedString = nextQuotedValue(p == PEEKED_SINGLE_QUOTED ? '\'' : '"');
            }
            validateAscii(peekedString);
            try {
                result = Integer.parseInt(peekedString);
                peeked = PEEKED_NONE;
                pathIndices[stackSize - 1]++;
                return result;
            } catch (NumberFormatException ignored) {
            }
        } else {
            throw unexpectedTokenError("an int");
        }
        peeked = PEEKED_BUFFERED;
        double asDouble;
        try {
            asDouble = Double.parseDouble(peekedString);
        } catch (NumberFormatException e) {
            NumberFormatException rethrown = new NumberFormatException("Expected an int but was " + peekedString + locationString());
            rethrown.initCause(e);
            throw rethrown;
        }
        result = (int) asDouble;
        if (result != asDouble) {
            throw new NumberFormatException("Expected an int but was " + peekedString + locationString());
        }
        peekedString = null;
        peeked = PEEKED_NONE;
        pathIndices[stackSize - 1]++;
        return result;
    }

    public void close() throws IOException {
        throw new java.lang.Error();
    }

    String locationString() {
        throw new java.lang.Error();
    }

    private IllegalStateException unexpectedTokenError(String expected) throws IOException {
        throw new java.lang.Error();
    }

    private void validateAscii(String s) throws MalformedJsonException {
        throw new java.lang.Error();
    }
}
