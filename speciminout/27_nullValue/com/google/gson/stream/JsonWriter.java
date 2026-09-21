package com.google.gson.stream;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public class JsonWriter implements Closeable, Flushable {

  private final Writer out = null;

  private String deferredName;

  private boolean serializeNulls;

  private void writeDeferredName() throws IOException {
    throw new java.lang.Error();
  }

  @CanIgnoreReturnValue
  public JsonWriter nullValue() throws IOException {
    if (deferredName != null) {
      if (serializeNulls) {
        writeDeferredName();
      } else {
        deferredName = null;
        return this;
      }
    }
    beforeValue();
    out.write("null");
    return this;
  }

  public void flush() throws IOException {
    throw new java.lang.Error();
  }

  public void close() throws IOException {
    throw new java.lang.Error();
  }

  @SuppressWarnings("fallthrough")
  private void beforeValue() throws IOException {
    throw new java.lang.Error();
  }
}
