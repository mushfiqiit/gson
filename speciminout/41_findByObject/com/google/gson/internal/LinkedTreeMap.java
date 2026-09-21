package com.google.gson.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Set;

@SuppressWarnings("serial")
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {

  Node<K, V> find(K key, boolean create) {
    throw new java.lang.Error();
  }

  @SuppressWarnings("unchecked")
  Node<K, V> findByObject(Object key) {
    try {
      return key != null ? find((K) key, false) : null;
    } catch (ClassCastException e) {
      return null;
    }
  }

  public Set<Entry<K, V>> entrySet() {
    throw new java.lang.Error();
  }

  static final class Node<K, V> implements Entry<K, V> {

    public K getKey() {
      throw new java.lang.Error();
    }

    public V getValue() {
      throw new java.lang.Error();
    }

    public V setValue(V value) {
      throw new java.lang.Error();
    }
  }
}
