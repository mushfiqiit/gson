package com.google.gson.stream;

import java.io.IOException;

public class JsonWriter {

    private int[] stack;

    private int stackSize;

    private void replaceTop(int topOfStack) {
        stack[stackSize - 1] = topOfStack;
    }

    public void flush() throws IOException {
        throw new java.lang.Error();
    }

    public void close() throws IOException {
        throw new java.lang.Error();
    }
}
