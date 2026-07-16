package com.google.gson.stream;

import java.io.IOException;

public class JsonReader {

    private final char[] buffer = null;

    private int pos;

    private int limit;

    private int lineNumber;

    private int lineStart;

    private void skipQuotedValue(char quote) throws IOException {
        char[] buffer = this.buffer;
        do {
            int p = pos;
            int l = limit;
            while (p < l) {
                int c = buffer[p++];
                if (c == quote) {
                    pos = p;
                    return;
                } else if (c == '\\') {
                    pos = p;
                    char unused = readEscapeCharacter();
                    p = pos;
                    l = limit;
                } else if (c == '\n') {
                    lineNumber++;
                    lineStart = p;
                }
            }
            pos = p;
        } while (fillBuffer(1));
        throw syntaxError("Unterminated string");
    }

    public void close() throws IOException {
        throw new java.lang.Error();
    }

    private boolean fillBuffer(int minimum) throws IOException {
        throw new java.lang.Error();
    }

    @SuppressWarnings("fallthrough")
    private char readEscapeCharacter() throws IOException {
        throw new java.lang.Error();
    }

    private MalformedJsonException syntaxError(String message) throws MalformedJsonException {
        throw new java.lang.Error();
    }
}
