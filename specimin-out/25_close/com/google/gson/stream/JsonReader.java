package com.google.gson.stream;

import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;

public class JsonReader implements Closeable {

    private static final int PEEKED_NONE = 0;

    private final Reader in = null;

    int peeked;

    private int[] stack;

    private int stackSize;

    public void close() throws IOException {
        peeked = PEEKED_NONE;
        stack[0] = JsonScope.CLOSED;
        stackSize = 1;
        in.close();
    }
}
