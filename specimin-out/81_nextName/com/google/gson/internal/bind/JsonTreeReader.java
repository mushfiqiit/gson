package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public final class JsonTreeReader extends JsonReader {

    private int stackSize;

    private String[] pathNames;

    private Object peekStack() {
        throw new java.lang.Error();
    }

    private void expect(JsonToken expected) throws IOException {
        throw new java.lang.Error();
    }

    private String nextName(boolean skipName) throws IOException {
        expect(JsonToken.NAME);
        Iterator<?> i = (Iterator<?>) peekStack();
        Map.Entry<?, ?> entry = (Map.Entry<?, ?>) i.next();
        String result = (String) entry.getKey();
        pathNames[stackSize - 1] = skipName ? "<skipped>" : result;
        push(entry.getValue());
        return result;
    }

    private void push(Object newTop) {
        throw new java.lang.Error();
    }
}
