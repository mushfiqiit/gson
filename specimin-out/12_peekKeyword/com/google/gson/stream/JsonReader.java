package com.google.gson.stream;

import com.google.gson.Strictness;
import java.io.IOException;

public class JsonReader {

    private static final int PEEKED_NONE = 0;

    private static final int PEEKED_TRUE = 0;

    private static final int PEEKED_FALSE = 0;

    private static final int PEEKED_NULL = 0;

    private Strictness strictness;

    private final char[] buffer = null;

    private int pos;

    private int limit;

    int peeked;

    private int peekKeyword() throws IOException {
        char c = buffer[pos];
        String keyword;
        String keywordUpper;
        int peeking;
        if (c == 't' || c == 'T') {
            keyword = "true";
            keywordUpper = "TRUE";
            peeking = PEEKED_TRUE;
        } else if (c == 'f' || c == 'F') {
            keyword = "false";
            keywordUpper = "FALSE";
            peeking = PEEKED_FALSE;
        } else if (c == 'n' || c == 'N') {
            keyword = "null";
            keywordUpper = "NULL";
            peeking = PEEKED_NULL;
        } else {
            return PEEKED_NONE;
        }
        boolean allowsUpperCased = strictness != Strictness.STRICT;
        int length = keyword.length();
        for (int i = 0; i < length; i++) {
            if (pos + i >= limit && !fillBuffer(i + 1)) {
                return PEEKED_NONE;
            }
            c = buffer[pos + i];
            boolean matched = c == keyword.charAt(i) || (allowsUpperCased && c == keywordUpper.charAt(i));
            if (!matched) {
                return PEEKED_NONE;
            }
        }
        if ((pos + length < limit || fillBuffer(length + 1)) && isLiteral(buffer[pos + length])) {
            return PEEKED_NONE;
        }
        pos += length;
        peeked = peeking;
        return peeked;
    }

    @SuppressWarnings("fallthrough")
    private boolean isLiteral(char c) throws IOException {
        throw new java.lang.Error();
    }

    public void close() throws IOException {
        throw new java.lang.Error();
    }

    private boolean fillBuffer(int minimum) throws IOException {
        throw new java.lang.Error();
    }
}
