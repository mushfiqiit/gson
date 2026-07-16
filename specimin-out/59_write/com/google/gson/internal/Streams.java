package com.google.gson.internal;

import java.io.IOException;
import java.io.Writer;

public final class Streams {

    private static final class AppendableWriter extends Writer {

        private final Appendable appendable = null;

        private final CurrentWrite currentWrite = null;

        @SuppressWarnings("UngroupedOverloads")
        public void write(char[] chars, int offset, int length) throws IOException {
            currentWrite.setChars(chars);
            appendable.append(currentWrite, offset, offset + length);
        }

        public void flush() throws IOException {
            throw new java.lang.Error();
        }

        public void close() throws IOException {
            throw new java.lang.Error();
        }

        private static class CurrentWrite implements CharSequence {

            void setChars(char[] chars) {
                throw new java.lang.Error();
            }

            public int length() {
                throw new java.lang.Error();
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
