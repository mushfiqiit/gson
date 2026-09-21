package com.google.gson.internal;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public final class GsonTypes {

  public static ParameterizedType newParameterizedTypeWithOwner(
      Type ownerType, Class<?> rawType, Type... typeArguments) {
    throw new java.lang.Error();
  }

  public static Class<?> getRawType(Type type) {
    throw new java.lang.Error();
  }

  public static boolean requiresOwnerType(Type rawType) {
    throw new java.lang.Error();
  }
}
