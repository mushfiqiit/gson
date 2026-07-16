package com.google.gson.stream;

import java.io.IOException;

public class JsonReader {

    private static final int PEEKED_NONE = 0;

    private static final int PEEKED_BEGIN_ARRAY = 0;

    int peeked;

    private int stackSize;

    private int[] pathIndices;

    public void beginArray() throws IOException {
        int p = peeked;
        if (p == PEEKED_NONE) {
            p = doPeek();
        }
        if (p == PEEKED_BEGIN_ARRAY) {
            push(JsonScope.EMPTY_ARRAY);
            pathIndices[stackSize - 1] = 0;
            peeked = PEEKED_NONE;
        } else {
            throw unexpectedTokenError("BEGIN_ARRAY");
        }
    }

    @SuppressWarnings("fallthrough")
    int doPeek() throws IOException {
        throw new java.lang.Error();
    }

    public void close() throws IOException {
        throw new java.lang.Error();
    }

    private void push(int newTop) throws MalformedJsonException {
        throw new java.lang.Error();
    }

    private IllegalStateException unexpectedTokenError(String expected) throws IOException {
        throw new java.lang.Error();
    }
}
