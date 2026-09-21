package com.google.gson.internal;

import static java.util.Objects.requireNonNull;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

public final class GsonTypes {

  public static Type canonicalize(Type type) {
    throw new java.lang.Error();
  }

  static void checkNotPrimitive(Type type) {
    throw new java.lang.Error();
  }

  private static final class WildcardTypeImpl implements WildcardType {

    private final Type upperBound;

    private final Type lowerBound;

    WildcardTypeImpl(Type[] upperBounds, Type[] lowerBounds) {
      if (lowerBounds.length > 1) {
        throw new IllegalArgumentException("At most one lower bound is supported");
      }
      if (upperBounds.length != 1) {
        throw new IllegalArgumentException("Exactly one upper bound must be specified");
      }
      if (lowerBounds.length == 1) {
        requireNonNull(lowerBounds[0]);
        checkNotPrimitive(lowerBounds[0]);
        if (upperBounds[0] != Object.class) {
          throw new IllegalArgumentException(
              "When lower bound is specified, upper bound must be Object");
        }
        this.lowerBound = canonicalize(lowerBounds[0]);
        this.upperBound = Object.class;
      } else {
        requireNonNull(upperBounds[0]);
        checkNotPrimitive(upperBounds[0]);
        this.lowerBound = null;
        this.upperBound = canonicalize(upperBounds[0]);
      }
    }

    public Type[] getUpperBounds() {
      throw new java.lang.Error();
    }

    public Type[] getLowerBounds() {
      throw new java.lang.Error();
    }
  }
}
