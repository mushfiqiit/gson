package com.google.gson.internal;

import java.util.AbstractList;
import java.util.ArrayList;

public class NonNullElementWrapperList<E> extends AbstractList<E> {

    private final ArrayList<E> delegate = null;

    public E get(int index) {
        return delegate.get(index);
    }

    public int size() {
        throw new java.lang.Error();
    }
}
