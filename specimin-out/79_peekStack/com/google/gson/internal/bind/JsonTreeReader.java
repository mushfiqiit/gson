package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;

public final class JsonTreeReader extends JsonReader {

    private Object[] stack;

    private int stackSize;

    private Object peekStack() {
        return stack[stackSize - 1];
    }
}
