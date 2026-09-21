package com.google.gson.internal;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

public final class Excluder implements TypeAdapterFactory, Cloneable {

  public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
    Class<?> rawType = type.getRawType();
    boolean skipSerialize = excludeClass(rawType, true);
    boolean skipDeserialize = excludeClass(rawType, false);
    if (!skipSerialize && !skipDeserialize) {
      return null;
    }
    return new TypeAdapter<T>() {

      private volatile TypeAdapter<T> delegate;

      public T read(JsonReader in) throws IOException {
        if (skipDeserialize) {
          in.skipValue();
          return null;
        }
        return delegate().read(in);
      }

      public void write(JsonWriter out, T value) throws IOException {
        if (skipSerialize) {
          out.nullValue();
          return;
        }
        delegate().write(out, value);
      }

      private TypeAdapter<T> delegate() {
        TypeAdapter<T> d = delegate;
        if (d == null) {
          d = delegate = gson.getDelegateAdapter(Excluder.this, type);
        }
        return d;
      }
    };
  }

  public boolean excludeClass(Class<?> clazz, boolean serialize) {
    throw new java.lang.Error();
  }
}
