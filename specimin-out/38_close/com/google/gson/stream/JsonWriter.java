package com.google.gson.stream;

import static com.google.gson.stream.JsonScope.NONEMPTY_DOCUMENT;
import java.io.Closeable;
import java.io.IOException;
import java.io.Writer;

public class JsonWriter implements Closeable {

    private final Writer out = null;

    private int[] stack;

    private int stackSize;

    public void flush() throws IOException {
        throw new java.lang.Error();
    }

    public void close() throws IOException {
        out.close();
        int size = stackSize;
        if (size > 1 || (size == 1 && stack[size - 1] != NONEMPTY_DOCUMENT)) {
            throw new IOException("Incomplete document");
        }
        stackSize = 0;
    }
}
