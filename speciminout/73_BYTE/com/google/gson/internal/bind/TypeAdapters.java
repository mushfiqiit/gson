package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

public final class TypeAdapters {

  public static final TypeAdapter<Number> BYTE =
      new TypeAdapter<Number>() {

        public Number read(JsonReader in) throws IOException {
          if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
          }
          int intValue;
          try {
            intValue = in.nextInt();
          } catch (NumberFormatException e) {
            throw new JsonSyntaxException(e);
          }
          if (intValue > 255 || intValue < Byte.MIN_VALUE) {
            throw new JsonSyntaxException(
                "Lossy conversion from " + intValue + " to byte; at path " + in.getPreviousPath());
          }
          return (byte) intValue;
        }

        public void write(JsonWriter out, Number value) throws IOException {
          if (value == null) {
            out.nullValue();
          } else {
            out.value(value.byteValue());
          }
        }
      };
}
