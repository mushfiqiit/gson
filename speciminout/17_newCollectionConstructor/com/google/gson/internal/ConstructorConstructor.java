package com.google.gson.internal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public final class ConstructorConstructor {

  private static ObjectConstructor<? extends Collection<?>> newCollectionConstructor(
      Class<?> rawType) {
    if (rawType.isAssignableFrom(ArrayList.class)) {
      return ArrayList::new;
    } else if (rawType.isAssignableFrom(LinkedHashSet.class)) {
      return LinkedHashSet::new;
    } else if (rawType.isAssignableFrom(TreeSet.class)) {
      return TreeSet::new;
    } else if (rawType.isAssignableFrom(ArrayDeque.class)) {
      return ArrayDeque::new;
    }
    return null;
  }
}
