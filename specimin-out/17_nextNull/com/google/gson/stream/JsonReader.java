package com.google.gson.stream;

import java.io.IOException;

public class JsonReader {

    private static final int PEEKED_NONE = 0;

    private static final int PEEKED_NULL = 0;

    int peeked;

    private int stackSize;

    private int[] pathIndices;

    @SuppressWarnings("fallthrough")
    int doPeek() throws IOException {
        throw new java.lang.Error();
    }

    public void nextNull() throws IOException {
        int p = peeked;
        if (p == PEEKED_NONE) {
            p = doPeek();
        }
        if (p == PEEKED_NULL) {
            peeked = PEEKED_NONE;
            pathIndices[stackSize - 1]++;
        } else {
            throw unexpectedTokenError("null");
        }
    }

    public void close() throws IOException {
        throw new java.lang.Error();
    }

    private IllegalStateException unexpectedTokenError(String expected) throws IOException {
        throw new java.lang.Error();
    }
}
