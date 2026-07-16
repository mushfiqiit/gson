package com.google.gson.stream;

import java.io.IOException;

public class JsonReader {

    private int[] stack;

    private int stackSize;

    private String[] pathNames;

    private int[] pathIndices;

    public void close() throws IOException {
        throw new java.lang.Error();
    }

    private String getPath(boolean usePreviousPath) {
        StringBuilder result = new StringBuilder().append('$');
        for (int i = 0; i < stackSize; i++) {
            int scope = stack[i];
            switch(scope) {
                case JsonScope.EMPTY_ARRAY:
                case JsonScope.NONEMPTY_ARRAY:
                    int pathIndex = pathIndices[i];
                    if (usePreviousPath && pathIndex > 0 && i == stackSize - 1) {
                        pathIndex--;
                    }
                    result.append('[').append(pathIndex).append(']');
                    break;
                case JsonScope.EMPTY_OBJECT:
                case JsonScope.DANGLING_NAME:
                case JsonScope.NONEMPTY_OBJECT:
                    result.append('.');
                    if (pathNames[i] != null) {
                        result.append(pathNames[i]);
                    }
                    break;
                case JsonScope.NONEMPTY_DOCUMENT:
                case JsonScope.EMPTY_DOCUMENT:
                case JsonScope.CLOSED:
                    break;
                default:
                    throw new AssertionError("Unknown scope value: " + scope);
            }
        }
        return result.toString();
    }
}
