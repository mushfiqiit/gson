package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.GsonTypes;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

public final class ArrayTypeAdapter<E> extends TypeAdapter<Object> {

  public static final TypeAdapterFactory FACTORY =
      new TypeAdapterFactory() {

        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
          Type type = typeToken.getType();
          if (!(type instanceof GenericArrayType
              || (type instanceof Class && ((Class<?>) type).isArray()))) {
            return null;
          }
          Type componentType = GsonTypes.getArrayComponentType(type);
          TypeAdapter<?> componentTypeAdapter = gson.getAdapter(TypeToken.get(componentType));
          @SuppressWarnings({"unchecked", "rawtypes"})
          TypeAdapter<T> arrayAdapter =
              new ArrayTypeAdapter(gson, componentTypeAdapter, GsonTypes.getRawType(componentType));
          return arrayAdapter;
        }
      };
}
