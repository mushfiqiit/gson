package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

public final class TypeAdapters {

  public static final TypeAdapter<Boolean> BOOLEAN_AS_STRING =
      new TypeAdapter<Boolean>() {

        public Boolean read(JsonReader in) throws IOException {
          if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
          }
          return Boolean.valueOf(in.nextString());
        }

        public void write(JsonWriter out, Boolean value) throws IOException {
          out.value(value == null ? "null" : value.toString());
        }
      };
}
