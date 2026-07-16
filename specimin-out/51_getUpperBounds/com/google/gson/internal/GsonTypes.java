package com.google.gson.internal;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

public final class GsonTypes {

    private static final class WildcardTypeImpl implements WildcardType {

        private final Type upperBound = null;

        public Type[] getUpperBounds() {
            return new Type[] { upperBound };
        }

        public Type[] getLowerBounds() {
            throw new java.lang.Error();
        }
    }
}
