package com.google.gson.stream;

import com.google.gson.Strictness;
import java.io.IOException;

public class JsonReader {

    private static final int PEEKED_NONE = 0;

    private static final int PEEKED_BEGIN_OBJECT = 0;

    private static final int PEEKED_END_OBJECT = 0;

    private static final int PEEKED_BEGIN_ARRAY = 0;

    private static final int PEEKED_END_ARRAY = 0;

    private static final int PEEKED_NULL = 0;

    private static final int PEEKED_SINGLE_QUOTED = 0;

    private static final int PEEKED_DOUBLE_QUOTED = 0;

    private static final int PEEKED_UNQUOTED = 0;

    private static final int PEEKED_SINGLE_QUOTED_NAME = 0;

    private static final int PEEKED_DOUBLE_QUOTED_NAME = 0;

    private static final int PEEKED_UNQUOTED_NAME = 0;

    private static final int PEEKED_EOF = 0;

    private Strictness strictness;

    private final char[] buffer = null;

    private int pos;

    private int limit;

    int peeked;

    private int[] stack;

    private int stackSize;

    @SuppressWarnings("fallthrough")
    int doPeek() throws IOException {
        int peekStack = stack[stackSize - 1];
        if (peekStack == JsonScope.EMPTY_ARRAY) {
            stack[stackSize - 1] = JsonScope.NONEMPTY_ARRAY;
        } else if (peekStack == JsonScope.NONEMPTY_ARRAY) {
            int c = nextNonWhitespace(true);
            switch(c) {
                case ']':
                    peeked = PEEKED_END_ARRAY;
                    return peeked;
                case ';':
                    checkLenient();
                case ',':
                    break;
                default:
                    throw syntaxError("Unterminated array");
            }
        } else if (peekStack == JsonScope.EMPTY_OBJECT || peekStack == JsonScope.NONEMPTY_OBJECT) {
            stack[stackSize - 1] = JsonScope.DANGLING_NAME;
            if (peekStack == JsonScope.NONEMPTY_OBJECT) {
                int c = nextNonWhitespace(true);
                switch(c) {
                    case '}':
                        peeked = PEEKED_END_OBJECT;
                        return peeked;
                    case ';':
                        checkLenient();
                    case ',':
                        break;
                    default:
                        throw syntaxError("Unterminated object");
                }
            }
            int c = nextNonWhitespace(true);
            switch(c) {
                case '"':
                    peeked = PEEKED_DOUBLE_QUOTED_NAME;
                    return peeked;
                case '\'':
                    checkLenient();
                    peeked = PEEKED_SINGLE_QUOTED_NAME;
                    return peeked;
                case '}':
                    if (peekStack != JsonScope.NONEMPTY_OBJECT) {
                        peeked = PEEKED_END_OBJECT;
                        return peeked;
                    } else {
                        throw syntaxError("Expected name");
                    }
                default:
                    checkLenient();
                    pos--;
                    if (isLiteral((char) c)) {
                        peeked = PEEKED_UNQUOTED_NAME;
                        return peeked;
                    } else {
                        throw syntaxError("Expected name");
                    }
            }
        } else if (peekStack == JsonScope.DANGLING_NAME) {
            stack[stackSize - 1] = JsonScope.NONEMPTY_OBJECT;
            int c = nextNonWhitespace(true);
            switch(c) {
                case ':':
                    break;
                case '=':
                    checkLenient();
                    if ((pos < limit || fillBuffer(1)) && buffer[pos] == '>') {
                        pos++;
                    }
                    break;
                default:
                    throw syntaxError("Expected ':'");
            }
        } else if (peekStack == JsonScope.EMPTY_DOCUMENT) {
            if (strictness == Strictness.LENIENT) {
                consumeNonExecutePrefix();
            }
            stack[stackSize - 1] = JsonScope.NONEMPTY_DOCUMENT;
        } else if (peekStack == JsonScope.NONEMPTY_DOCUMENT) {
            int c = nextNonWhitespace(false);
            if (c == -1) {
                peeked = PEEKED_EOF;
                return peeked;
            } else {
                checkLenient();
                pos--;
            }
        } else if (peekStack == JsonScope.CLOSED) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int c = nextNonWhitespace(true);
        switch(c) {
            case ']':
                if (peekStack == JsonScope.EMPTY_ARRAY) {
                    peeked = PEEKED_END_ARRAY;
                    return peeked;
                }
            case ';':
            case ',':
                if (peekStack == JsonScope.EMPTY_ARRAY || peekStack == JsonScope.NONEMPTY_ARRAY) {
                    checkLenient();
                    pos--;
                    peeked = PEEKED_NULL;
                    return peeked;
                } else {
                    throw syntaxError("Unexpected value");
                }
            case '\'':
                checkLenient();
                peeked = PEEKED_SINGLE_QUOTED;
                return peeked;
            case '"':
                peeked = PEEKED_DOUBLE_QUOTED;
                return peeked;
            case '[':
                peeked = PEEKED_BEGIN_ARRAY;
                return peeked;
            case '{':
                peeked = PEEKED_BEGIN_OBJECT;
                return peeked;
            default:
                pos--;
        }
        int result = peekKeyword();
        if (result != PEEKED_NONE) {
            return result;
        }
        result = peekNumber();
        if (result != PEEKED_NONE) {
            return result;
        }
        if (!isLiteral(buffer[pos])) {
            throw syntaxError("Expected value");
        }
        checkLenient();
        peeked = PEEKED_UNQUOTED;
        return peeked;
    }

    private int peekKeyword() throws IOException {
        throw new java.lang.Error();
    }

    private int peekNumber() throws IOException {
        throw new java.lang.Error();
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

    private int nextNonWhitespace(boolean throwOnEof) throws IOException {
        throw new java.lang.Error();
    }

    private void checkLenient() throws MalformedJsonException {
        throw new java.lang.Error();
    }

    private MalformedJsonException syntaxError(String message) throws MalformedJsonException {
        throw new java.lang.Error();
    }

    private void consumeNonExecutePrefix() throws IOException {
        throw new java.lang.Error();
    }
}
