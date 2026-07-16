package com.google.gson.internal.bind;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;

public final class JsonTreeReader extends JsonReader {

    private int stackSize;

    private int[] pathIndices;

    @CanIgnoreReturnValue
    private Object popStack() {
        throw new java.lang.Error();
    }

    private void expect(JsonToken expected) throws IOException {
        throw new java.lang.Error();
    }

    public void nextNull() throws IOException {
        expect(JsonToken.NULL);
        popStack();
        if (stackSize > 0) {
            pathIndices[stackSize - 1]++;
        }
    }
}
