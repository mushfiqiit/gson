package com.google.gson.stream;

import java.io.IOException;

public class JsonReader {

    private final char[] buffer = null;

    private int pos;

    private int limit;

    @SuppressWarnings("fallthrough")
    private void skipUnquotedValue() throws IOException {
        do {
            int i = 0;
            for (; pos + i < limit; i++) {
                switch(buffer[pos + i]) {
                    case '/':
                    case '\\':
                    case ';':
                    case '#':
                    case '=':
                        checkLenient();
                    case '{':
                    case '}':
                    case '[':
                    case ']':
                    case ':':
                    case ',':
                    case ' ':
                    case '\t':
                    case '\f':
                    case '\r':
                    case '\n':
                        pos += i;
                        return;
                    default:
                }
            }
            pos += i;
        } while (fillBuffer(1));
    }

    public void close() throws IOException {
        throw new java.lang.Error();
    }

    private boolean fillBuffer(int minimum) throws IOException {
        throw new java.lang.Error();
    }

    private void checkLenient() throws MalformedJsonException {
        throw new java.lang.Error();
    }
}
