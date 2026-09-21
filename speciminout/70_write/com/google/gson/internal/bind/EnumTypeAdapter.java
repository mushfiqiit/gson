package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Map;

class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {

  private final Map<T, String> constantToName = null;

  public void write(JsonWriter out, T value) throws IOException {
    out.value(value == null ? null : constantToName.get(value));
  }
}
