package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

public final class TypeAdapters {

  public static final TypeAdapter<Boolean> BOOLEAN =
      new TypeAdapter<Boolean>() {

        public Boolean read(JsonReader in) throws IOException {
          JsonToken peek = in.peek();
          if (peek == JsonToken.NULL) {
            in.nextNull();
            return null;
          } else if (peek == JsonToken.STRING) {
            return Boolean.parseBoolean(in.nextString());
          }
          return in.nextBoolean();
        }

        public void write(JsonWriter out, Boolean value) throws IOException {
          out.value(value);
        }
      };
}
