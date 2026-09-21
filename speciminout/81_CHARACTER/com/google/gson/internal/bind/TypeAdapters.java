package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

public final class TypeAdapters {

  public static final TypeAdapter<Character> CHARACTER =
      new TypeAdapter<Character>() {

        public Character read(JsonReader in) throws IOException {
          if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
          }
          String str = in.nextString();
          int length = str.length();
          if (length != 1) {
            throw new JsonSyntaxException(
                "Expecting single character, got: '"
                    + str
                    + "' (length "
                    + length
                    + "); at path "
                    + in.getPreviousPath());
          }
          return str.charAt(0);
        }

        public void write(JsonWriter out, Character value) throws IOException {
          out.value(value == null ? null : String.valueOf(value));
        }
      };
}
