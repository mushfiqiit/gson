package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {

  static final TypeAdapterFactory FACTORY =
      new TypeAdapterFactory() {

        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
          Class<? super T> rawType = typeToken.getRawType();
          if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
            return null;
          }
          if (!rawType.isEnum()) {
            rawType = rawType.getSuperclass();
          }
          @SuppressWarnings({"rawtypes", "unchecked"})
          TypeAdapter<T> adapter = (TypeAdapter<T>) new EnumTypeAdapter(rawType);
          return adapter;
        }
      };

  private EnumTypeAdapter(Class<T> classOfT) {
    throw new java.lang.Error();
  }
}
