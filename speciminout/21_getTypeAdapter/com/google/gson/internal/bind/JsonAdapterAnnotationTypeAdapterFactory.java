package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.reflect.TypeToken;

public final class JsonAdapterAnnotationTypeAdapterFactory implements TypeAdapterFactory {

  private static final class DummyTypeAdapterFactory implements TypeAdapterFactory {

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
      throw new java.lang.Error();
    }
  }

  private static final DummyTypeAdapterFactory TREE_TYPE_CLASS_DUMMY_FACTORY = null;

  private static final DummyTypeAdapterFactory TREE_TYPE_FIELD_DUMMY_FACTORY = null;

  @SuppressWarnings("unchecked")
  public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> targetType) {
    throw new java.lang.Error();
  }

  private static Object createAdapter(
      ConstructorConstructor constructorConstructor, Class<?> adapterClass) {
    throw new java.lang.Error();
  }

  private TypeAdapterFactory putFactoryAndGetCurrent(Class<?> rawType, TypeAdapterFactory factory) {
    throw new java.lang.Error();
  }

  TypeAdapter<?> getTypeAdapter(
      ConstructorConstructor constructorConstructor,
      Gson gson,
      TypeToken<?> type,
      JsonAdapter annotation,
      boolean isClassAnnotation) {
    Object instance = createAdapter(constructorConstructor, annotation.value());
    TypeAdapter<?> typeAdapter;
    boolean nullSafe = annotation.nullSafe();
    if (instance instanceof TypeAdapter) {
      typeAdapter = (TypeAdapter<?>) instance;
    } else if (instance instanceof TypeAdapterFactory) {
      TypeAdapterFactory factory = (TypeAdapterFactory) instance;
      if (isClassAnnotation) {
        factory = putFactoryAndGetCurrent(type.getRawType(), factory);
      }
      typeAdapter = factory.create(gson, type);
    } else if (instance instanceof JsonSerializer || instance instanceof JsonDeserializer) {
      JsonSerializer<?> serializer =
          instance instanceof JsonSerializer ? (JsonSerializer<?>) instance : null;
      JsonDeserializer<?> deserializer =
          instance instanceof JsonDeserializer ? (JsonDeserializer<?>) instance : null;
      TypeAdapterFactory skipPast;
      if (isClassAnnotation) {
        skipPast = TREE_TYPE_CLASS_DUMMY_FACTORY;
      } else {
        skipPast = TREE_TYPE_FIELD_DUMMY_FACTORY;
      }
      @SuppressWarnings({"unchecked", "rawtypes"})
      TypeAdapter<?> tempAdapter =
          new TreeTypeAdapter(serializer, deserializer, gson, type, skipPast, nullSafe);
      typeAdapter = tempAdapter;
      nullSafe = false;
    } else {
      throw new IllegalArgumentException(
          "Invalid attempt to bind an instance of "
              + instance.getClass().getName()
              + " as a @JsonAdapter for "
              + type.toString()
              + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory,"
              + " JsonSerializer or JsonDeserializer.");
    }
    if (typeAdapter != null && nullSafe) {
      typeAdapter = typeAdapter.nullSafe();
    }
    return typeAdapter;
  }
}
