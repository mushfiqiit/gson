package com.google.gson.stream;

import java.io.IOException;

public class JsonReader {

    private final char[] buffer = null;

    private int pos;

    private int limit;

    @SuppressWarnings("fallthrough")
    private String nextUnquotedValue() throws IOException {
        StringBuilder builder = null;
        int i = 0;
        findNonLiteralCharacter: while (true) {
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
                        break findNonLiteralCharacter;
                    default:
                }
            }
            if (i < buffer.length) {
                if (fillBuffer(i + 1)) {
                    continue;
                } else {
                    break;
                }
            }
            if (builder == null) {
                builder = new StringBuilder(Math.max(i, 16));
            }
            builder.append(buffer, pos, i);
            pos += i;
            i = 0;
            if (!fillBuffer(1)) {
                break;
            }
        }
        String result = (builder == null) ? new String(buffer, pos, i) : builder.append(buffer, pos, i).toString();
        pos += i;
        return result;
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
