package com.google.gson.internal;

import java.util.AbstractList;
import java.util.ArrayList;

public class NonNullElementWrapperList<E> extends AbstractList<E> {

    private final ArrayList<E> delegate = null;

    public E get(int index) {
        throw new java.lang.Error();
    }

    public int size() {
        throw new java.lang.Error();
    }

    private E nonNull(E element) {
        throw new java.lang.Error();
    }

    public void add(int index, E element) {
        delegate.add(index, nonNull(element));
    }
}
