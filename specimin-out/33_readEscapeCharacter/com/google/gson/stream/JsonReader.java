package com.google.gson.stream;

import com.google.gson.Strictness;
import java.io.IOException;

public class JsonReader {

    private Strictness strictness;

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

    @SuppressWarnings("fallthrough")
    private char readEscapeCharacter() throws IOException {
        if (pos == limit && !fillBuffer(1)) {
            throw syntaxError("Unterminated escape sequence");
        }
        char escaped = buffer[pos++];
        switch(escaped) {
            case 'u':
                if (pos + 4 > limit && !fillBuffer(4)) {
                    throw syntaxError("Unterminated escape sequence");
                }
                int result = 0;
                for (int i = pos, end = i + 4; i < end; i++) {
                    char c = buffer[i];
                    result <<= 4;
                    if (c >= '0' && c <= '9') {
                        result += (c - '0');
                    } else if (c >= 'a' && c <= 'f') {
                        result += (c - 'a' + 10);
                    } else if (c >= 'A' && c <= 'F') {
                        result += (c - 'A' + 10);
                    } else {
                        throw syntaxError("Malformed Unicode escape \\u" + new String(buffer, pos, 4));
                    }
                }
                pos += 4;
                return (char) result;
            case 't':
                return '\t';
            case 'b':
                return '\b';
            case 'n':
                return '\n';
            case 'r':
                return '\r';
            case 'f':
                return '\f';
            case '\n':
                if (strictness == Strictness.STRICT) {
                    throw syntaxError("Cannot escape a newline character in strict mode");
                }
                lineNumber++;
                lineStart = pos;
            case '\'':
                if (strictness == Strictness.STRICT) {
                    throw syntaxError("Invalid escaped character \"'\" in strict mode");
                }
            case '"':
            case '\\':
            case '/':
                return escaped;
            default:
                throw syntaxError("Invalid escape sequence");
        }
    }

    private MalformedJsonException syntaxError(String message) throws MalformedJsonException {
        throw new java.lang.Error();
    }
}
