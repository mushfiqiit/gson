package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.util.Iterator;

public final class JsonTreeReader extends JsonReader {

    private static final Object SENTINEL_CLOSED = null;

    private Object[] stack;

    private int stackSize;

    public JsonToken peek() throws IOException {
        if (stackSize == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object o = peekStack();
        if (o instanceof Iterator) {
            boolean isObject = stack[stackSize - 2] instanceof JsonObject;
            Iterator<?> iterator = (Iterator<?>) o;
            if (iterator.hasNext()) {
                if (isObject) {
                    return JsonToken.NAME;
                } else {
                    push(iterator.next());
                    return peek();
                }
            } else {
                return isObject ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            }
        } else if (o instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else if (o instanceof JsonArray) {
            return JsonToken.BEGIN_ARRAY;
        } else if (o instanceof JsonPrimitive) {
            JsonPrimitive primitive = (JsonPrimitive) o;
            if (primitive.isString()) {
                return JsonToken.STRING;
            } else if (primitive.isBoolean()) {
                return JsonToken.BOOLEAN;
            } else if (primitive.isNumber()) {
                return JsonToken.NUMBER;
            } else {
                throw new AssertionError();
            }
        } else if (o instanceof JsonNull) {
            return JsonToken.NULL;
        } else if (o == SENTINEL_CLOSED) {
            throw new IllegalStateException("JsonReader is closed");
        } else {
            throw new MalformedJsonException("Custom JsonElement subclass " + o.getClass().getName() + " is not supported");
        }
    }

    private Object peekStack() {
        throw new java.lang.Error();
    }

    private void push(Object newTop) {
        throw new java.lang.Error();
    }
}
