package com.google.gson.internal.bind;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;

public final class JsonTreeReader extends JsonReader {

    private int stackSize;

    private int[] pathIndices;

    public JsonToken peek() throws IOException {
        throw new java.lang.Error();
    }

    private Object peekStack() {
        throw new java.lang.Error();
    }

    @CanIgnoreReturnValue
    private Object popStack() {
        throw new java.lang.Error();
    }

    public double nextDouble() throws IOException {
        JsonToken token = peek();
        if (token != JsonToken.NUMBER && token != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + token + locationString());
        }
        double result = ((JsonPrimitive) peekStack()).getAsDouble();
        if (!isLenient() && (Double.isNaN(result) || Double.isInfinite(result))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + result);
        }
        popStack();
        if (stackSize > 0) {
            pathIndices[stackSize - 1]++;
        }
        return result;
    }

    private String locationString() {
        throw new java.lang.Error();
    }
}
