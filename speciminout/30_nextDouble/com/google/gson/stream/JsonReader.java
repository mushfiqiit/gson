package com.google.gson.stream;

import com.google.gson.Strictness;
import java.io.Closeable;
import java.io.IOException;

public class JsonReader implements Closeable {

  private static final int PEEKED_NONE = 0;

  private static final int PEEKED_SINGLE_QUOTED = 0;

  private static final int PEEKED_DOUBLE_QUOTED = 0;

  private static final int PEEKED_UNQUOTED = 0;

  private static final int PEEKED_BUFFERED = 0;

  private static final int PEEKED_LONG = 0;

  private static final int PEEKED_NUMBER = 0;

  private Strictness strictness;

  private final char[] buffer = null;

  private int pos;

  int peeked;

  private long peekedLong;

  private int peekedNumberLength;

  private String peekedString;

  private int stackSize;

  private int[] pathIndices;

  @SuppressWarnings("fallthrough")
  int doPeek() throws IOException {
    throw new java.lang.Error();
  }

  private void recordPromotedName(String name) {
    throw new java.lang.Error();
  }

  public double nextDouble() throws IOException {
    int p = peeked;
    if (p == PEEKED_NONE) {
      p = doPeek();
    }
    switch (p) {
      case PEEKED_LONG:
        peeked = PEEKED_NONE;
        pathIndices[stackSize - 1]++;
        return (double) peekedLong;
      case PEEKED_NUMBER:
        peekedString = new String(buffer, pos, peekedNumberLength);
        pos += peekedNumberLength;
        break;
      case PEEKED_SINGLE_QUOTED:
      case PEEKED_DOUBLE_QUOTED:
        peekedString = nextQuotedValue(p == PEEKED_SINGLE_QUOTED ? '\'' : '"');
        break;
      case PEEKED_UNQUOTED:
        peekedString = nextUnquotedValue();
        break;
      case PEEKED_BUFFERED:
        break;
      default:
        throw unexpectedTokenError("a double");
    }
    peeked = PEEKED_BUFFERED;
    double result;
    try {
      result = Double.parseDouble(peekedString);
    } catch (NumberFormatException e) {
      NumberFormatException rethrown =
          new NumberFormatException("Expected a double but was " + peekedString + locationString());
      rethrown.initCause(e);
      throw rethrown;
    }
    if (strictness != Strictness.LENIENT && (Double.isNaN(result) || Double.isInfinite(result))) {
      throw syntaxError("JSON forbids NaN and infinities: " + result);
    }
    String literal = peekedString;
    peekedString = null;
    peeked = PEEKED_NONE;
    pathIndices[stackSize - 1]++;
    recordPromotedName(literal);
    return result;
  }

  private String nextQuotedValue(char quote) throws IOException {
    throw new java.lang.Error();
  }

  @SuppressWarnings("fallthrough")
  private String nextUnquotedValue() throws IOException {
    throw new java.lang.Error();
  }

  public void close() throws IOException {
    throw new java.lang.Error();
  }

  String locationString() {
    throw new java.lang.Error();
  }

  private MalformedJsonException syntaxError(String message) throws MalformedJsonException {
    throw new java.lang.Error();
  }

  private IllegalStateException unexpectedTokenError(String expected) throws IOException {
    throw new java.lang.Error();
  }
}
