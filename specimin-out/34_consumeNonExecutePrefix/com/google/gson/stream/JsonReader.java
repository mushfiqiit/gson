package com.google.gson.stream;

import java.io.IOException;

public class JsonReader {

    private final char[] buffer = null;

    private int pos;

    private int limit;

    public void close() throws IOException {
        throw new java.lang.Error();
    }

    private boolean fillBuffer(int minimum) throws IOException {
        throw new java.lang.Error();
    }

    private int nextNonWhitespace(boolean throwOnEof) throws IOException {
        throw new java.lang.Error();
    }

    private void consumeNonExecutePrefix() throws IOException {
        int unused = nextNonWhitespace(true);
        pos--;
        if (pos + 5 > limit && !fillBuffer(5)) {
            return;
        }
        int p = pos;
        char[] buf = buffer;
        if (buf[p] != ')' || buf[p + 1] != ']' || buf[p + 2] != '}' || buf[p + 3] != '\'' || buf[p + 4] != '\n') {
            return;
        }
        pos += 5;
    }
}
