package com.google.gson.internal;

import java.util.AbstractMap;
import java.util.Set;

@SuppressWarnings("serial")
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> {

    int size;

    public int size() {
        return size;
    }

    public Set<Entry<K, V>> entrySet() {
        throw new java.lang.Error();
    }
}
