package com.google.gson.stream;

import java.io.EOFException;
import java.io.IOException;

public class JsonReader {

    private final char[] buffer = null;

    private int pos;

    private int limit;

    private int lineNumber;

    private int lineStart;

    public void close() throws IOException {
        throw new java.lang.Error();
    }

    private boolean fillBuffer(int minimum) throws IOException {
        throw new java.lang.Error();
    }

    private int nextNonWhitespace(boolean throwOnEof) throws IOException {
        char[] buffer = this.buffer;
        int p = pos;
        int l = limit;
        while (true) {
            if (p == l) {
                pos = p;
                if (!fillBuffer(1)) {
                    break;
                }
                p = pos;
                l = limit;
            }
            int c = buffer[p++];
            if (c == '\n') {
                lineNumber++;
                lineStart = p;
                continue;
            } else if (c == ' ' || c == '\r' || c == '\t') {
                continue;
            }
            if (c == '/') {
                pos = p;
                if (p == l) {
                    pos--;
                    boolean charsLoaded = fillBuffer(2);
                    pos++;
                    if (!charsLoaded) {
                        return c;
                    }
                }
                checkLenient();
                char peek = buffer[pos];
                switch(peek) {
                    case '*':
                        pos++;
                        if (!skipTo("*/")) {
                            throw syntaxError("Unterminated comment");
                        }
                        p = pos + 2;
                        l = limit;
                        continue;
                    case '/':
                        pos++;
                        skipToEndOfLine();
                        p = pos;
                        l = limit;
                        continue;
                    default:
                        return c;
                }
            } else if (c == '#') {
                pos = p;
                checkLenient();
                skipToEndOfLine();
                p = pos;
                l = limit;
            } else {
                pos = p;
                return c;
            }
        }
        if (throwOnEof) {
            throw new EOFException("End of input" + locationString());
        } else {
            return -1;
        }
    }

    private void checkLenient() throws MalformedJsonException {
        throw new java.lang.Error();
    }

    private void skipToEndOfLine() throws IOException {
        throw new java.lang.Error();
    }

    private boolean skipTo(String toFind) throws IOException {
        throw new java.lang.Error();
    }

    String locationString() {
        throw new java.lang.Error();
    }

    private MalformedJsonException syntaxError(String message) throws MalformedJsonException {
        throw new java.lang.Error();
    }
}
