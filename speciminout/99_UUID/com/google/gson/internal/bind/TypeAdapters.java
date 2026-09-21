package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.UUID;

public final class TypeAdapters {

  public static final TypeAdapter<UUID> UUID =
      new TypeAdapter<UUID>() {

        public UUID read(JsonReader in) throws IOException {
          if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
          }
          String s = in.nextString();
          try {
            return java.util.UUID.fromString(s);
          } catch (IllegalArgumentException e) {
            throw new JsonSyntaxException(
                "Failed parsing '" + s + "' as UUID; at path " + in.getPreviousPath(), e);
          }
        }

        public void write(JsonWriter out, UUID value) throws IOException {
          out.value(value == null ? null : value.toString());
        }
      };
}
