package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import java.util.Iterator;

public final class JsonTreeReader extends JsonReader {

    private Object[] stack;

    private int stackSize;

    private String[] pathNames;

    private int[] pathIndices;

    private String getPath(boolean usePreviousPath) {
        StringBuilder result = new StringBuilder().append('$');
        for (int i = 0; i < stackSize; i++) {
            if (stack[i] instanceof JsonArray) {
                if (++i < stackSize && stack[i] instanceof Iterator) {
                    int pathIndex = pathIndices[i];
                    if (usePreviousPath && pathIndex > 0 && (i == stackSize - 1 || i == stackSize - 2)) {
                        pathIndex--;
                    }
                    result.append('[').append(pathIndex).append(']');
                }
            } else if (stack[i] instanceof JsonObject) {
                if (++i < stackSize && stack[i] instanceof Iterator) {
                    result.append('.');
                    if (pathNames[i] != null) {
                        result.append(pathNames[i]);
                    }
                }
            }
        }
        return result.toString();
    }
}
