package com.google.gson.stream;

import java.io.IOException;
import java.util.Arrays;

public class JsonWriter {

    private int[] stack;

    private int stackSize;

    private void push(int newTop) {
        if (stackSize == stack.length) {
            stack = Arrays.copyOf(stack, stackSize * 2);
        }
        stack[stackSize++] = newTop;
    }

    public void flush() throws IOException {
        throw new java.lang.Error();
    }

    public void close() throws IOException {
        throw new java.lang.Error();
    }
}
