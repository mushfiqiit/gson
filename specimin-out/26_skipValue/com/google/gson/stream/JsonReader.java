package com.google.gson.stream;

import java.io.IOException;

public class JsonReader {

    private static final int PEEKED_NONE = 0;

    private static final int PEEKED_BEGIN_OBJECT = 0;

    private static final int PEEKED_END_OBJECT = 0;

    private static final int PEEKED_BEGIN_ARRAY = 0;

    private static final int PEEKED_END_ARRAY = 0;

    private static final int PEEKED_SINGLE_QUOTED = 0;

    private static final int PEEKED_DOUBLE_QUOTED = 0;

    private static final int PEEKED_UNQUOTED = 0;

    private static final int PEEKED_SINGLE_QUOTED_NAME = 0;

    private static final int PEEKED_DOUBLE_QUOTED_NAME = 0;

    private static final int PEEKED_UNQUOTED_NAME = 0;

    private static final int PEEKED_NUMBER = 0;

    private static final int PEEKED_EOF = 0;

    private int pos;

    int peeked;

    private int peekedNumberLength;

    private int stackSize;

    private String[] pathNames;

    private int[] pathIndices;

    @SuppressWarnings("fallthrough")
    int doPeek() throws IOException {
        throw new java.lang.Error();
    }

    private void skipQuotedValue(char quote) throws IOException {
        throw new java.lang.Error();
    }

    @SuppressWarnings("fallthrough")
    private void skipUnquotedValue() throws IOException {
        throw new java.lang.Error();
    }

    public void close() throws IOException {
        throw new java.lang.Error();
    }

    public void skipValue() throws IOException {
        int count = 0;
        do {
            int p = peeked;
            if (p == PEEKED_NONE) {
                p = doPeek();
            }
            switch(p) {
                case PEEKED_BEGIN_ARRAY:
                    push(JsonScope.EMPTY_ARRAY);
                    count++;
                    break;
                case PEEKED_BEGIN_OBJECT:
                    push(JsonScope.EMPTY_OBJECT);
                    count++;
                    break;
                case PEEKED_END_ARRAY:
                    stackSize--;
                    count--;
                    break;
                case PEEKED_END_OBJECT:
                    if (count == 0) {
                        pathNames[stackSize - 1] = null;
                    }
                    stackSize--;
                    count--;
                    break;
                case PEEKED_UNQUOTED:
                    skipUnquotedValue();
                    break;
                case PEEKED_SINGLE_QUOTED:
                    skipQuotedValue('\'');
                    break;
                case PEEKED_DOUBLE_QUOTED:
                    skipQuotedValue('"');
                    break;
                case PEEKED_UNQUOTED_NAME:
                    skipUnquotedValue();
                    if (count == 0) {
                        pathNames[stackSize - 1] = "<skipped>";
                    }
                    break;
                case PEEKED_SINGLE_QUOTED_NAME:
                    skipQuotedValue('\'');
                    if (count == 0) {
                        pathNames[stackSize - 1] = "<skipped>";
                    }
                    break;
                case PEEKED_DOUBLE_QUOTED_NAME:
                    skipQuotedValue('"');
                    if (count == 0) {
                        pathNames[stackSize - 1] = "<skipped>";
                    }
                    break;
                case PEEKED_NUMBER:
                    pos += peekedNumberLength;
                    break;
                case PEEKED_EOF:
                    return;
                default:
            }
            peeked = PEEKED_NONE;
        } while (count > 0);
        pathIndices[stackSize - 1]++;
    }

    private void push(int newTop) throws MalformedJsonException {
        throw new java.lang.Error();
    }
}
