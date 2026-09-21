package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

public final class TypeAdapters {

  public static final TypeAdapter<Number> INTEGER =
      new TypeAdapter<Number>() {

        public Number read(JsonReader in) throws IOException {
          if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
          }
          try {
            return in.nextInt();
          } catch (NumberFormatException e) {
            throw new JsonSyntaxException(e);
          }
        }

        public void write(JsonWriter out, Number value) throws IOException {
          if (value == null) {
            out.nullValue();
          } else {
            out.value(value.intValue());
          }
        }
      };
}
