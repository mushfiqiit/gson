package com.google.gson.stream;

import com.google.gson.FormattingStyle;
import com.google.gson.Strictness;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;
import java.util.regex.Pattern;

public class JsonWriter implements Closeable, Flushable {

  private static final Pattern VALID_JSON_NUMBER_PATTERN = null;

  private static final String[] REPLACEMENT_CHARS = null;

  private static final String[] HTML_SAFE_REPLACEMENT_CHARS = null;

  private final Writer out;

  private int[] stack;

  private int stackSize;

  private FormattingStyle formattingStyle;

  private String formattedColon;

  private String formattedComma;

  private boolean usesEmptyNewlineAndIndent;

  private Strictness strictness;

  private boolean htmlSafe;

  private String deferredName;

  private boolean serializeNulls;

  public JsonWriter(Writer out) {
    this.out = Objects.requireNonNull(out, "out == null");
    setFormattingStyle(FormattingStyle.COMPACT);
  }

  public final void setFormattingStyle(FormattingStyle formattingStyle) {
    throw new java.lang.Error();
  }

  public void flush() throws IOException {
    throw new java.lang.Error();
  }

  public void close() throws IOException {
    throw new java.lang.Error();
  }
}
