package com.google.gson.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Set;

@SuppressWarnings("serial")
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {

  public Set<Entry<K, V>> entrySet() {
    throw new java.lang.Error();
  }

  static final class Node<K, V> implements Entry<K, V> {

    Node<K, V> parent;

    Node<K, V> left;

    Node<K, V> right;

    Node<K, V> next;

    Node<K, V> prev;

    final K key;

    final boolean allowNullValue;

    V value;

    int height;

    Node(boolean allowNullValue) {
      key = null;
      this.allowNullValue = allowNullValue;
      next = prev = this;
    }

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
