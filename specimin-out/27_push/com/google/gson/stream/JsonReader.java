package com.google.gson.stream;

import java.io.IOException;
import java.util.Arrays;

public class JsonReader {

    private int nestingLimit;

    private int[] stack;

    private int stackSize;

    private String[] pathNames;

    private int[] pathIndices;

    public void close() throws IOException {
        throw new java.lang.Error();
    }

    private void push(int newTop) throws MalformedJsonException {
        if (stackSize - 1 >= nestingLimit) {
            throw new MalformedJsonException("Nesting limit " + nestingLimit + " reached" + locationString());
        }
        if (stackSize == stack.length) {
            int newLength = stackSize * 2;
            stack = Arrays.copyOf(stack, newLength);
            pathIndices = Arrays.copyOf(pathIndices, newLength);
            pathNames = Arrays.copyOf(pathNames, newLength);
        }
        stack[stackSize++] = newTop;
    }

    String locationString() {
        throw new java.lang.Error();
    }
}
