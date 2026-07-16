package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import java.util.Arrays;

public final class JsonTreeReader extends JsonReader {

    private Object[] stack;

    private int stackSize;

    private String[] pathNames;

    private int[] pathIndices;

    private void push(Object newTop) {
        if (stackSize == stack.length) {
            int newLength = stackSize * 2;
            stack = Arrays.copyOf(stack, newLength);
            pathIndices = Arrays.copyOf(pathIndices, newLength);
            pathNames = Arrays.copyOf(pathNames, newLength);
        }
        stack[stackSize++] = newTop;
    }
}
