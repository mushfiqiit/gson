package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

public final class TypeAdapters {

  public static final TypeAdapter<Number> LONG_AS_STRING =
      new TypeAdapter<Number>() {

        public Number read(JsonReader in) throws IOException {
          if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
          }
          return in.nextLong();
        }

        public void write(JsonWriter out, Number value) throws IOException {
          if (value == null) {
            out.nullValue();
            return;
          }
          out.value(value.toString());
        }
      };
}
