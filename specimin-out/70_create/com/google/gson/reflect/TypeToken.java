package com.google.gson.reflect;

import java.lang.reflect.Type;

public class TypeToken<T> {

    public final Class<? super T> getRawType() {
        throw new java.lang.Error();
    }

    public final Type getType() {
        throw new java.lang.Error();
    }

    public static TypeToken<?> get(Type type) {
        throw new java.lang.Error();
    }
}
