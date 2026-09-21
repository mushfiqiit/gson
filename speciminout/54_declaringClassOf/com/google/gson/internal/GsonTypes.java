package com.google.gson.internal;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.TypeVariable;

public final class GsonTypes {

  private static Class<?> declaringClassOf(TypeVariable<?> typeVariable) {
    GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
    return genericDeclaration instanceof Class ? (Class<?>) genericDeclaration : null;
  }
}
