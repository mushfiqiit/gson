package com.google.gson.stream;

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

    private boolean skipTo(String toFind) throws IOException {
        int length = toFind.length();
        outer: for (; pos + length <= limit || fillBuffer(length); pos++) {
            if (buffer[pos] == '\n') {
                lineNumber++;
                lineStart = pos + 1;
                continue;
            }
            for (int c = 0; c < length; c++) {
                if (buffer[pos + c] != toFind.charAt(c)) {
                    continue outer;
                }
            }
            return true;
        }
        return false;
    }
}
