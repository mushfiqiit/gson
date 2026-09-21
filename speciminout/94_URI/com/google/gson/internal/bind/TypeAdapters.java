package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public final class TypeAdapters {

  public static final TypeAdapter<URI> URI =
      new TypeAdapter<URI>() {

        public URI read(JsonReader in) throws IOException {
          if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
          }
          String nextString = in.nextString();
          if (nextString.equals("null")) {
            return null;
          }
          try {
            return new URI(nextString);
          } catch (URISyntaxException e) {
            throw new JsonSyntaxException(
                "Failed parsing '" + nextString + "' as URI; at path " + in.getPreviousPath(), e);
          }
        }

        public void write(JsonWriter out, URI value) throws IOException {
          out.value(value == null ? null : value.toString());
        }
      };
}
