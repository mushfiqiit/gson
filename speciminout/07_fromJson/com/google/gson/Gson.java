package com.google.gson;

import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public final class Gson {

  public <T> T fromJson(JsonReader reader, TypeToken<T> typeOfT)
      throws JsonIOException, JsonSyntaxException {
    throw new java.lang.Error();
  }

  public <T> T fromJson(JsonElement json, TypeToken<T> typeOfT) throws JsonSyntaxException {
    if (json == null) {
      return null;
    }
    return fromJson(new JsonTreeReader(json), typeOfT);
  }
}
