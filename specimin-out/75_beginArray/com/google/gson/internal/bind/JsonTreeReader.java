package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;

public final class JsonTreeReader extends JsonReader {

    private int stackSize;

    private int[] pathIndices;

    public void beginArray() throws IOException {
        expect(JsonToken.BEGIN_ARRAY);
        JsonArray array = (JsonArray) peekStack();
        push(array.iterator());
        pathIndices[stackSize - 1] = 0;
    }

    private Object peekStack() {
        throw new java.lang.Error();
    }

    private void expect(JsonToken expected) throws IOException {
        throw new java.lang.Error();
    }

    private void push(Object newTop) {
        throw new java.lang.Error();
    }
}
