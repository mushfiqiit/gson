package com.google.gson;

import com.google.gson.reflect.TypeToken;
import java.io.Reader;
import java.io.StringReader;

public final class Gson {

  public <T> T fromJson(String json, TypeToken<T> typeOfT) throws JsonSyntaxException {
    if (json == null) {
      return null;
    }
    StringReader reader = new StringReader(json);
    return fromJson(reader, typeOfT);
  }

  public <T> T fromJson(Reader json, TypeToken<T> typeOfT)
      throws JsonIOException, JsonSyntaxException {
    throw new java.lang.Error();
  }
}
