package com.google.gson.internal;

import java.lang.reflect.Modifier;

public final class ConstructorConstructor {

  static String checkInstantiable(Class<?> c) {
    int modifiers = c.getModifiers();
    if (Modifier.isInterface(modifiers)) {
      return "Interfaces can't be instantiated! Register an InstanceCreator"
          + " or a TypeAdapter for this type. Interface name: "
          + c.getName();
    }
    if (Modifier.isAbstract(modifiers)) {
      return "Abstract classes can't be instantiated! Adjust the R8 configuration or register"
          + " an InstanceCreator or a TypeAdapter for this type. Class name: "
          + c.getName()
          + "\nSee "
          + TroubleshootingGuide.createUrl("r8-abstract-class");
    }
    return null;
  }
}
