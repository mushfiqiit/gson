package com.google.gson.stream;

import com.google.gson.Strictness;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Objects;

public class JsonReader implements Closeable {

  private static final long MIN_INCOMPLETE_INTEGER = 0L;

  private static final int PEEKED_NONE = 0;

  private static final int PEEKED_BEGIN_OBJECT = 0;

  private static final int PEEKED_END_OBJECT = 0;

  private static final int PEEKED_BEGIN_ARRAY = 0;

  private static final int PEEKED_END_ARRAY = 0;

  private static final int PEEKED_TRUE = 0;

  private static final int PEEKED_FALSE = 0;

  private static final int PEEKED_NULL = 0;

  private static final int PEEKED_SINGLE_QUOTED = 0;

  private static final int PEEKED_DOUBLE_QUOTED = 0;

  private static final int PEEKED_UNQUOTED = 0;

  private static final int PEEKED_BUFFERED = 0;

  private static final int PEEKED_SINGLE_QUOTED_NAME = 0;

  private static final int PEEKED_DOUBLE_QUOTED_NAME = 0;

  private static final int PEEKED_UNQUOTED_NAME = 0;

  private static final int PEEKED_LONG = 0;

  private static final int PEEKED_NUMBER = 0;

  private static final int PEEKED_EOF = 0;

  private static final int NUMBER_CHAR_NONE = 0;

  private static final int NUMBER_CHAR_SIGN = 0;

  private static final int NUMBER_CHAR_DIGIT = 0;

  private static final int NUMBER_CHAR_DECIMAL = 0;

  private static final int NUMBER_CHAR_FRACTION_DIGIT = 0;

  private static final int NUMBER_CHAR_EXP_E = 0;

  private static final int NUMBER_CHAR_EXP_SIGN = 0;

  private static final int NUMBER_CHAR_EXP_DIGIT = 0;

  private final Reader in;

  private Strictness strictness;

  static final int DEFAULT_NESTING_LIMIT = 0;

  private int nestingLimit;

  static final int BUFFER_SIZE = 0;

  private final char[] buffer = null;

  private int pos;

  private int limit;

  private long bufferStart;

  private int lineNumber;

  private int lineStart;

  int peeked;

  private long peekedLong;

  private int peekedNumberLength;

  private String peekedString;

  private int[] stack;

  private int stackSize;

  private String[] pathNames;

  private int[] pathIndices;

  private boolean promotedName;

  public JsonReader(Reader in) {
    this.in = Objects.requireNonNull(in, "in == null");
  }

  public void close() throws IOException {
    throw new java.lang.Error();
  }
}
