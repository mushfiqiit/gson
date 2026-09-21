package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.util.Date;

public final class DefaultDateTypeAdapter<T extends Date> extends TypeAdapter<T> {

  public abstract static class DateType<T extends Date> {

    protected abstract T deserialize(Date date);
  }

  private final DateType<T> dateType = null;

  public T read(JsonReader in) throws IOException {
    if (in.peek() == JsonToken.NULL) {
      in.nextNull();
      return null;
    }
    Date date = deserializeToDate(in);
    return dateType.deserialize(date);
  }

  private Date deserializeToDate(JsonReader in) throws IOException {
    throw new java.lang.Error();
  }
}
