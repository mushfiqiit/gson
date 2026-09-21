package com.google.gson;

public abstract class TypeAdapter<T> {

  public final TypeAdapter<T> nullSafe() {
    throw new java.lang.Error();
  }
}
