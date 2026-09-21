package com.google.gson.reflect;

import com.google.gson.internal.GsonTypes;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Objects;

public class TypeToken<T> {

  @SuppressWarnings("unchecked")
  private TypeToken(Type type) {
    throw new java.lang.Error();
  }

  public static <T> TypeToken<T> get(Class<T> type) {
    throw new java.lang.Error();
  }

  public static TypeToken<?> getParameterized(Type rawType, Type... typeArguments) {
    Objects.requireNonNull(rawType);
    Objects.requireNonNull(typeArguments);
    if (!(rawType instanceof Class)) {
      throw new IllegalArgumentException("rawType must be of type Class, but was " + rawType);
    }
    Class<?> rawClass = (Class<?>) rawType;
    TypeVariable<?>[] typeVariables = rawClass.getTypeParameters();
    int expectedArgsCount = typeVariables.length;
    int actualArgsCount = typeArguments.length;
    if (actualArgsCount != expectedArgsCount) {
      throw new IllegalArgumentException(
          rawClass.getName()
              + " requires "
              + expectedArgsCount
              + " type arguments, but got "
              + actualArgsCount);
    }
    if (typeArguments.length == 0) {
      return get(rawClass);
    }
    if (GsonTypes.requiresOwnerType(rawType)) {
      throw new IllegalArgumentException(
          "Raw type "
              + rawClass.getName()
              + " is not supported because it requires specifying an owner type");
    }
    for (int i = 0; i < expectedArgsCount; i++) {
      Type typeArgument =
          Objects.requireNonNull(typeArguments[i], "Type argument must not be null");
      Class<?> rawTypeArgument = GsonTypes.getRawType(typeArgument);
      TypeVariable<?> typeVariable = typeVariables[i];
      for (Type bound : typeVariable.getBounds()) {
        Class<?> rawBound = GsonTypes.getRawType(bound);
        if (!rawBound.isAssignableFrom(rawTypeArgument)) {
          throw new IllegalArgumentException(
              "Type argument "
                  + typeArgument
                  + " does not satisfy bounds for type variable "
                  + typeVariable
                  + " declared by "
                  + rawType);
        }
      }
    }
    return new TypeToken<>(GsonTypes.newParameterizedTypeWithOwner(null, rawClass, typeArguments));
  }
}
