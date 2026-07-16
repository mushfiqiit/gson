package com.google.gson.stream;

import java.io.IOException;

public class JsonWriter {

    private int[] stack;

    private int stackSize;

    private int peek() {
        if (stackSize == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return stack[stackSize - 1];
    }

    public void flush() throws IOException {
        throw new java.lang.Error();
    }

    public void close() throws IOException {
        throw new java.lang.Error();
    }
}
