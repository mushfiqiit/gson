package com.google.gson.internal;

import java.io.IOException;
import java.io.Writer;

public final class Streams {

    private static final class AppendableWriter extends Writer {

        private final Appendable appendable = null;

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

        public Writer append(CharSequence csq, int start, int end) throws IOException {
            appendable.append(csq, start, end);
            return this;
        }
    }
}
