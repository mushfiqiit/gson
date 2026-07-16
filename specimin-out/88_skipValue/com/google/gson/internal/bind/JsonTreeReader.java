package com.google.gson.internal.bind;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;

public final class JsonTreeReader extends JsonReader {

    private int stackSize;

    private int[] pathIndices;

    public void endArray() throws IOException {
        throw new java.lang.Error();
    }

    public void endObject() throws IOException {
        throw new java.lang.Error();
    }

    public JsonToken peek() throws IOException {
        throw new java.lang.Error();
    }

    @CanIgnoreReturnValue
    private Object popStack() {
        throw new java.lang.Error();
    }

    private String nextName(boolean skipName) throws IOException {
        throw new java.lang.Error();
    }

    public void skipValue() throws IOException {
        JsonToken peeked = peek();
        switch(peeked) {
            case NAME:
                @SuppressWarnings("unused")
                String unused = nextName(true);
                break;
            case END_ARRAY:
                endArray();
                break;
            case END_OBJECT:
                endObject();
                break;
            case END_DOCUMENT:
                break;
            default:
                popStack();
                if (stackSize > 0) {
                    pathIndices[stackSize - 1]++;
                }
                break;
        }
    }
}
