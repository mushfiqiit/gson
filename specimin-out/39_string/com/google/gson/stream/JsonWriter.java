package com.google.gson.stream;

import java.io.IOException;
import java.io.Writer;

public class JsonWriter {

    private static final String[] REPLACEMENT_CHARS = null;

    private static final String[] HTML_SAFE_REPLACEMENT_CHARS = null;

    private final Writer out = null;

    private boolean htmlSafe;

    public void flush() throws IOException {
        throw new java.lang.Error();
    }

    public void close() throws IOException {
        throw new java.lang.Error();
    }

    private void string(String value) throws IOException {
        String[] replacements = htmlSafe ? HTML_SAFE_REPLACEMENT_CHARS : REPLACEMENT_CHARS;
        out.write('\"');
        int last = 0;
        int length = value.length();
        for (int i = 0; i < length; i++) {
            char c = value.charAt(i);
            String replacement;
            if (c < 128) {
                replacement = replacements[c];
                if (replacement == null) {
                    continue;
                }
            } else if (c == '\u2028') {
                replacement = "\\u2028";
            } else if (c == '\u2029') {
                replacement = "\\u2029";
            } else {
                continue;
            }
            if (last < i) {
                out.write(value, last, i - last);
            }
            out.write(replacement);
            last = i + 1;
        }
        if (last < length) {
            out.write(value, last, length - last);
        }
        out.write('\"');
    }
}
