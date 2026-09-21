package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

public final class TypeAdapters {

  public static final TypeAdapter<String> STRING =
      new TypeAdapter<String>() {

        public String read(JsonReader in) throws IOException {
          JsonToken peek = in.peek();
          if (peek == JsonToken.NULL) {
            in.nextNull();
            return null;
          }
          if (peek == JsonToken.BOOLEAN) {
            return Boolean.toString(in.nextBoolean());
          }
          return in.nextString();
        }

        public void write(JsonWriter out, String value) throws IOException {
          out.value(value);
        }
      };
}
