package com.google.gson.stream;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public class JsonWriter implements Closeable, Flushable {

  @CanIgnoreReturnValue
  public JsonWriter value(Number value) throws IOException {
    throw new java.lang.Error();
  }

  public void flush() throws IOException {
    throw new java.lang.Error();
  }

  public void close() throws IOException {
    throw new java.lang.Error();
  }
}
