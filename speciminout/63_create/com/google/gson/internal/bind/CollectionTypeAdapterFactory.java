package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.GsonTypes;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Collection;

public final class CollectionTypeAdapterFactory implements TypeAdapterFactory {

  private final ConstructorConstructor constructorConstructor = null;

  public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
    Type type = typeToken.getType();
    Class<? super T> rawType = typeToken.getRawType();
    if (!Collection.class.isAssignableFrom(rawType)) {
      return null;
    }
    Type elementType = GsonTypes.getCollectionElementType(type, rawType);
    TypeAdapter<?> elementTypeAdapter = gson.getAdapter(TypeToken.get(elementType));
    TypeAdapter<?> wrappedTypeAdapter =
        new TypeAdapterRuntimeTypeWrapper<>(gson, elementTypeAdapter, elementType);
    boolean allowUnsafe = false;
    ObjectConstructor<T> constructor = constructorConstructor.get(typeToken, allowUnsafe);
    @SuppressWarnings({"unchecked", "rawtypes"})
    TypeAdapter<T> result = new Adapter(wrappedTypeAdapter, constructor);
    return result;
  }

  private static final class Adapter<E> extends TypeAdapter<Collection<E>> {

    Adapter(
        TypeAdapter<E> elementTypeAdapter, ObjectConstructor<? extends Collection<E>> constructor) {
      throw new java.lang.Error();
    }
  }
}
