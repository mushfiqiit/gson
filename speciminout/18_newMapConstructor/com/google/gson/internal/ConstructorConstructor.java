package com.google.gson.internal;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

public final class ConstructorConstructor {

  private static ObjectConstructor<? extends Map<?, Object>> newMapConstructor(Class<?> rawType) {
    if (rawType.isAssignableFrom(LinkedHashMap.class)) {
      return LinkedHashMap::new;
    } else if (rawType.isAssignableFrom(TreeMap.class)) {
      return TreeMap::new;
    } else if (rawType.isAssignableFrom(ConcurrentHashMap.class)) {
      return ConcurrentHashMap::new;
    } else if (rawType.isAssignableFrom(ConcurrentSkipListMap.class)) {
      return ConcurrentSkipListMap::new;
    }
    return null;
  }
}
