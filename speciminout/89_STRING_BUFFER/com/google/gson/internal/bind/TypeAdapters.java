package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

public final class TypeAdapters {

  public static final TypeAdapter<StringBuffer> STRING_BUFFER =
      new TypeAdapter<StringBuffer>() {

        public StringBuffer read(JsonReader in) throws IOException {
          if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
          }
          return new StringBuffer(in.nextString());
        }

        public void write(JsonWriter out, StringBuffer value) throws IOException {
          out.value(value == null ? null : value.toString());
        }
      };
}
