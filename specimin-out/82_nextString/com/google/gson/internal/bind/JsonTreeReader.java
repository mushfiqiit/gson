package com.google.gson.internal.bind;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;

public final class JsonTreeReader extends JsonReader {

    private int stackSize;

    private int[] pathIndices;

    public JsonToken peek() throws IOException {
        throw new java.lang.Error();
    }

    @CanIgnoreReturnValue
    private Object popStack() {
        throw new java.lang.Error();
    }

    public String nextString() throws IOException {
        JsonToken token = peek();
        if (token != JsonToken.STRING && token != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + token + locationString());
        }
        String result = ((JsonPrimitive) popStack()).getAsString();
        if (stackSize > 0) {
            pathIndices[stackSize - 1]++;
        }
        return result;
    }

    private String locationString() {
        throw new java.lang.Error();
    }
}
