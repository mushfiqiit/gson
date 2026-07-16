package com.google.gson.stream;

import java.io.IOException;

public class JsonReader {

    private static final int PEEKED_NONE = 0;

    private static final int PEEKED_END_OBJECT = 0;

    int peeked;

    private int stackSize;

    private String[] pathNames;

    private int[] pathIndices;

    public void endObject() throws IOException {
        int p = peeked;
        if (p == PEEKED_NONE) {
            p = doPeek();
        }
        if (p == PEEKED_END_OBJECT) {
            stackSize--;
            pathNames[stackSize] = null;
            pathIndices[stackSize - 1]++;
            peeked = PEEKED_NONE;
        } else {
            throw unexpectedTokenError("END_OBJECT");
        }
    }

    @SuppressWarnings("fallthrough")
    int doPeek() throws IOException {
        throw new java.lang.Error();
    }

    public void close() throws IOException {
        throw new java.lang.Error();
    }

    private IllegalStateException unexpectedTokenError(String expected) throws IOException {
        throw new java.lang.Error();
    }
}
