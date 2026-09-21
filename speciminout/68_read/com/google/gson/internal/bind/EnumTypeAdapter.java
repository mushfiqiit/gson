package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.util.Map;

class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {

  private final Map<String, T> nameToConstant = null;

  private final Map<String, T> stringToConstant = null;

  public T read(JsonReader in) throws IOException {
    if (in.peek() == JsonToken.NULL) {
      in.nextNull();
      return null;
    }
    String key = in.nextString();
    T constant = nameToConstant.get(key);
    return (constant == null) ? stringToConstant.get(key) : constant;
  }
}
