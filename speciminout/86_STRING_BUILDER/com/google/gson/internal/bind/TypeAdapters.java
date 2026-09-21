package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

public final class TypeAdapters {

  public static final TypeAdapter<StringBuilder> STRING_BUILDER =
      new TypeAdapter<StringBuilder>() {

        public StringBuilder read(JsonReader in) throws IOException {
          if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
          }
          return new StringBuilder(in.nextString());
        }

        public void write(JsonWriter out, StringBuilder value) throws IOException {
          out.value(value == null ? null : value.toString());
        }
      };
}
