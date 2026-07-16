package com.google.gson.internal;

import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

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

        public void write(String str, int off, int len) throws IOException {
            Objects.requireNonNull(str);
            appendable.append(str, off, off + len);
        }
    }
}
