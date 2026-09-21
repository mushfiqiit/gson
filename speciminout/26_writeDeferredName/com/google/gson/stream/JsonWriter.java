package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public class JsonWriter implements Closeable, Flushable {

  private String deferredName;

  private void writeDeferredName() throws IOException {
    if (deferredName != null) {
      beforeName();
      string(deferredName);
      deferredName = null;
    }
  }

  public void flush() throws IOException {
    throw new java.lang.Error();
  }

  public void close() throws IOException {
    throw new java.lang.Error();
  }

  private void string(String value) throws IOException {
    throw new java.lang.Error();
  }

  private void beforeName() throws IOException {
    throw new java.lang.Error();
  }
}
