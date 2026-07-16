package com.google.gson.internal;

import java.lang.reflect.Type;

public final class GsonTypes {

    public static String typeToString(Type type) {
        throw new java.lang.Error();
    }

    private static final class ParameterizedTypeImpl {

        private final Type rawType = null;

        private final Type[] typeArguments = null;

        public Type[] getActualTypeArguments() {
            throw new java.lang.Error();
        }

        public Type getRawType() {
            throw new java.lang.Error();
        }

        public Type getOwnerType() {
            throw new java.lang.Error();
        }

        public String toString() {
            int length = typeArguments.length;
            if (length == 0) {
                return typeToString(rawType);
            }
            StringBuilder stringBuilder = new StringBuilder(30 * (length + 1));
            stringBuilder.append(typeToString(rawType)).append("<").append(typeToString(typeArguments[0]));
            for (int i = 1; i < length; i++) {
                stringBuilder.append(", ").append(typeToString(typeArguments[i]));
            }
            return stringBuilder.append(">").toString();
        }
    }
}
