package com.google.gson.internal.bind;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.gson.stream.JsonReader;

public final class JsonTreeReader extends JsonReader {

    private Object[] stack;

    private int stackSize;

    @CanIgnoreReturnValue
    private Object popStack() {
        Object result = stack[--stackSize];
        stack[stackSize] = null;
        return result;
    }
}
