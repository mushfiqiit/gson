package com.google.gson.internal;

import java.util.Collection;
import java.util.Map;

public final class ConstructorConstructor {

  private static <T> ObjectConstructor<T> newDefaultImplementationConstructor(
      Class<? super T> rawType) {
    if (Collection.class.isAssignableFrom(rawType)) {
      @SuppressWarnings("unchecked")
      ObjectConstructor<T> constructor = (ObjectConstructor<T>) newCollectionConstructor(rawType);
      return constructor;
    }
    if (Map.class.isAssignableFrom(rawType)) {
      @SuppressWarnings("unchecked")
      ObjectConstructor<T> constructor = (ObjectConstructor<T>) newMapConstructor(rawType);
      return constructor;
    }
    return null;
  }

  private static ObjectConstructor<? extends Collection<?>> newCollectionConstructor(
      Class<?> rawType) {
    throw new java.lang.Error();
  }

  private static ObjectConstructor<? extends Map<?, Object>> newMapConstructor(Class<?> rawType) {
    throw new java.lang.Error();
  }
}
