package com.google.gson.internal;

import com.google.gson.ReflectionAccessFilter.FilterResult;
import com.google.gson.internal.reflect.ReflectionHelper;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public final class ConstructorConstructor {

  private static <T> ObjectConstructor<T> newDefaultConstructor(
      Class<? super T> rawType, FilterResult filterResult) {
    if (Modifier.isAbstract(rawType.getModifiers())) {
      return null;
    }
    Constructor<? super T> constructor;
    try {
      constructor = rawType.getDeclaredConstructor();
    } catch (NoSuchMethodException e) {
      return null;
    }
    boolean canAccess =
        filterResult == FilterResult.ALLOW
            || (ReflectionAccessFilterHelper.canAccess(constructor, null)
                && (filterResult != FilterResult.BLOCK_ALL
                    || Modifier.isPublic(constructor.getModifiers())));
    if (!canAccess) {
      String message =
          "Unable to invoke no-args constructor of "
              + rawType
              + ";"
              + " constructor is not accessible and ReflectionAccessFilter does not permit making"
              + " it accessible. Register an InstanceCreator or a TypeAdapter for this type, change"
              + " the visibility of the constructor or adjust the access filter.";
      return new ThrowingObjectConstructor<>(message);
    }
    if (filterResult == FilterResult.ALLOW) {
      String exceptionMessage = ReflectionHelper.tryMakeAccessible(constructor);
      if (exceptionMessage != null) {
        return new ThrowingObjectConstructor<>(exceptionMessage);
      }
    }
    return () -> {
      try {
        @SuppressWarnings("unchecked")
        T newInstance = (T) constructor.newInstance();
        return newInstance;
      } catch (InstantiationException e) {
        throw new RuntimeException(
            "Failed to invoke constructor '"
                + ReflectionHelper.constructorToString(constructor)
                + "' with no args",
            e);
      } catch (InvocationTargetException e) {
        throw new RuntimeException(
            "Failed to invoke constructor '"
                + ReflectionHelper.constructorToString(constructor)
                + "' with no args",
            e.getCause());
      } catch (IllegalAccessException e) {
        throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e);
      }
    };
  }

  private static final class ThrowingObjectConstructor<T> implements ObjectConstructor<T> {

    ThrowingObjectConstructor(String exceptionMessage) {
      throw new java.lang.Error();
    }
  }
}
