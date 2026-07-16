package com.google.gson.internal;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;

@SuppressWarnings("serial")
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> {

    int size;

    public Set<Entry<K, V>> entrySet() {
        throw new java.lang.Error();
    }

    final class KeySet extends AbstractSet<K> {

        public int size() {
            return size;
        }

        public Iterator<K> iterator() {
            throw new java.lang.Error();
        }
    }
}
