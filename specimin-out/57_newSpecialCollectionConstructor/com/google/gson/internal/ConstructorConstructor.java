package com.google.gson.internal;

import com.google.gson.JsonIOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumMap;
import java.util.EnumSet;

public final class ConstructorConstructor {

    private static <T> ObjectConstructor<T> newSpecialCollectionConstructor(Type type, Class<? super T> rawType) {
        if (EnumSet.class.isAssignableFrom(rawType)) {
            return () -> {
                if (type instanceof ParameterizedType) {
                    Type elementType = ((ParameterizedType) type).getActualTypeArguments()[0];
                    if (elementType instanceof Class) {
                        @SuppressWarnings({ "unchecked", "rawtypes" })
                        T set = (T) EnumSet.noneOf((Class) elementType);
                        return set;
                    } else {
                        throw new JsonIOException("Invalid EnumSet type: " + type);
                    }
                } else {
                    throw new JsonIOException("Invalid EnumSet type: " + type);
                }
            };
        } else if (rawType == EnumMap.class) {
            return () -> {
                if (type instanceof ParameterizedType) {
                    Type elementType = ((ParameterizedType) type).getActualTypeArguments()[0];
                    if (elementType instanceof Class) {
                        @SuppressWarnings({ "unchecked", "rawtypes" })
                        T map = (T) new EnumMap((Class) elementType);
                        return map;
                    } else {
                        throw new JsonIOException("Invalid EnumMap type: " + type);
                    }
                } else {
                    throw new JsonIOException("Invalid EnumMap type: " + type);
                }
            };
        }
        return null;
    }
}
