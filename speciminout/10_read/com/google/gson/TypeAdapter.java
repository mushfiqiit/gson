package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;

public abstract class TypeAdapter<T> {

  public abstract T read(JsonReader in) throws IOException;

  private final class NullSafeTypeAdapter extends TypeAdapter<T> {

    public T read(JsonReader reader) throws IOException {
      if (reader.peek() == JsonToken.NULL) {
        reader.nextNull();
        return null;
      }
      return TypeAdapter.this.read(reader);
    }
  }
}
