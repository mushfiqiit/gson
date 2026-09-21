package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public final class TypeAdapters {

  public static final TypeAdapter<URL> URL =
      new TypeAdapter<URL>() {

        public URL read(JsonReader in) throws IOException {
          if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
          }
          String nextString = in.nextString();
          if (nextString.equals("null")) {
            return null;
          }
          try {
            return new URL(nextString);
          } catch (MalformedURLException e) {
            throw new JsonSyntaxException(
                "Failed parsing '" + nextString + "' as URL; at path " + in.getPreviousPath(), e);
          }
        }

        public void write(JsonWriter out, URL value) throws IOException {
          out.value(value == null ? null : value.toExternalForm());
        }
      };
}
