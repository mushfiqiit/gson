package com.google.gson.internal;

import java.io.IOException;
import java.io.Writer;

public final class Streams {

    private static final class AppendableWriter extends Writer {

        @SuppressWarnings("UngroupedOverloads")
        public void write(char[] chars, int offset, int length) throws IOException {
            throw new java.lang.Error();
        }

        public void flush() throws IOException {
            throw new java.lang.Error();
        }

        public void close() throws IOException {
            throw new java.lang.Error();
        }

        private static class CurrentWrite implements CharSequence {

            private char[] chars;

            public int length() {
                return chars.length;
            }

            public char charAt(int i) {
                throw new java.lang.Error();
            }

            public CharSequence subSequence(int start, int end) {
                throw new java.lang.Error();
            }
        }
    }
}
