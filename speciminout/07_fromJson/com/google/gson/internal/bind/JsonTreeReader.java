package com.google.gson.internal.bind;

import com.google.gson.JsonElement;
import com.google.gson.stream.JsonReader;
import java.io.Reader;

public final class JsonTreeReader extends JsonReader {

  private static final Reader UNREADABLE_READER = null;

  public JsonTreeReader(JsonElement element) {
    super(UNREADABLE_READER);
  }
}
