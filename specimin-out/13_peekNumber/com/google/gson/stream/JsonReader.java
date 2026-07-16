package com.google.gson.stream;

import java.io.IOException;

public class JsonReader {

    private static final long MIN_INCOMPLETE_INTEGER = 0L;

    private static final int PEEKED_NONE = 0;

    private static final int PEEKED_LONG = 0;

    private static final int PEEKED_NUMBER = 0;

    private static final int NUMBER_CHAR_NONE = 0;

    private static final int NUMBER_CHAR_SIGN = 0;

    private static final int NUMBER_CHAR_DIGIT = 0;

    private static final int NUMBER_CHAR_DECIMAL = 0;

    private static final int NUMBER_CHAR_FRACTION_DIGIT = 0;

    private static final int NUMBER_CHAR_EXP_E = 0;

    private static final int NUMBER_CHAR_EXP_SIGN = 0;

    private static final int NUMBER_CHAR_EXP_DIGIT = 0;

    private final char[] buffer = null;

    private int pos;

    private int limit;

    int peeked;

    private long peekedLong;

    private int peekedNumberLength;

    private int peekNumber() throws IOException {
        char[] buffer = this.buffer;
        int p = pos;
        int l = limit;
        long value = 0;
        boolean negative = false;
        boolean fitsInLong = true;
        int last = NUMBER_CHAR_NONE;
        int i = 0;
        charactersOfNumber: for (; true; i++) {
            if (p + i == l) {
                if (i == buffer.length) {
                    return PEEKED_NONE;
                }
                if (!fillBuffer(i + 1)) {
                    break;
                }
                p = pos;
                l = limit;
            }
            char c = buffer[p + i];
            switch(c) {
                case '-':
                    if (last == NUMBER_CHAR_NONE) {
                        negative = true;
                        last = NUMBER_CHAR_SIGN;
                        continue;
                    } else if (last == NUMBER_CHAR_EXP_E) {
                        last = NUMBER_CHAR_EXP_SIGN;
                        continue;
                    }
                    return PEEKED_NONE;
                case '+':
                    if (last == NUMBER_CHAR_EXP_E) {
                        last = NUMBER_CHAR_EXP_SIGN;
                        continue;
                    }
                    return PEEKED_NONE;
                case 'e':
                case 'E':
                    if (last == NUMBER_CHAR_DIGIT || last == NUMBER_CHAR_FRACTION_DIGIT) {
                        last = NUMBER_CHAR_EXP_E;
                        continue;
                    }
                    return PEEKED_NONE;
                case '.':
                    if (last == NUMBER_CHAR_DIGIT) {
                        last = NUMBER_CHAR_DECIMAL;
                        continue;
                    }
                    return PEEKED_NONE;
                default:
                    if (c < '0' || c > '9') {
                        if (!isLiteral(c)) {
                            break charactersOfNumber;
                        }
                        return PEEKED_NONE;
                    }
                    if (last == NUMBER_CHAR_SIGN || last == NUMBER_CHAR_NONE) {
                        value = -(c - '0');
                        last = NUMBER_CHAR_DIGIT;
                    } else if (last == NUMBER_CHAR_DIGIT) {
                        if (fitsInLong && value == 0) {
                            return PEEKED_NONE;
                        }
                        long newValue = value * 10 - (c - '0');
                        fitsInLong &= value > MIN_INCOMPLETE_INTEGER || (value == MIN_INCOMPLETE_INTEGER && newValue < value);
                        value = newValue;
                    } else if (last == NUMBER_CHAR_DECIMAL) {
                        last = NUMBER_CHAR_FRACTION_DIGIT;
                    } else if (last == NUMBER_CHAR_EXP_E || last == NUMBER_CHAR_EXP_SIGN) {
                        last = NUMBER_CHAR_EXP_DIGIT;
                    }
            }
        }
        if (last == NUMBER_CHAR_DIGIT && fitsInLong && (value != Long.MIN_VALUE || negative) && (value != 0 || !negative)) {
            peekedLong = negative ? value : -value;
            pos += i;
            peeked = PEEKED_LONG;
            return peeked;
        } else if (last == NUMBER_CHAR_DIGIT || last == NUMBER_CHAR_FRACTION_DIGIT || last == NUMBER_CHAR_EXP_DIGIT) {
            peekedNumberLength = i;
            peeked = PEEKED_NUMBER;
            return peeked;
        } else {
            return PEEKED_NONE;
        }
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
