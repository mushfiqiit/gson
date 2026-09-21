package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

public final class TypeAdapters {

  public static final TypeAdapter<LazilyParsedNumber> LAZILY_PARSED_NUMBER =
      new TypeAdapter<LazilyParsedNumber>() {

        public LazilyParsedNumber read(JsonReader in) throws IOException {
          if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
          }
          return new LazilyParsedNumber(in.nextString());
        }

        public void write(JsonWriter out, LazilyParsedNumber value) throws IOException {
          out.value(value);
        }
      };
}
