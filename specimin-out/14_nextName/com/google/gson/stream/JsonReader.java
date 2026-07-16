package com.google.gson.stream;

import java.io.IOException;

public class JsonReader {

    private static final int PEEKED_NONE = 0;

    private static final int PEEKED_SINGLE_QUOTED_NAME = 0;

    private static final int PEEKED_DOUBLE_QUOTED_NAME = 0;

    private static final int PEEKED_UNQUOTED_NAME = 0;

    int peeked;

    private int stackSize;

    private String[] pathNames;

    @SuppressWarnings("fallthrough")
    int doPeek() throws IOException {
        throw new java.lang.Error();
    }

    public String nextName() throws IOException {
        int p = peeked;
        if (p == PEEKED_NONE) {
            p = doPeek();
        }
        String result;
        if (p == PEEKED_UNQUOTED_NAME) {
            result = nextUnquotedValue();
        } else if (p == PEEKED_SINGLE_QUOTED_NAME) {
            result = nextQuotedValue('\'');
        } else if (p == PEEKED_DOUBLE_QUOTED_NAME) {
            result = nextQuotedValue('"');
        } else {
            throw unexpectedTokenError("a name");
        }
        peeked = PEEKED_NONE;
        pathNames[stackSize - 1] = result;
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
