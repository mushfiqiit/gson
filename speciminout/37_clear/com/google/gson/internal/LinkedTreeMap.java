package com.google.gson.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Set;

@SuppressWarnings("serial")
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {

  Node<K, V> root;

  int size;

  int modCount;

  final Node<K, V> header = null;

  public void clear() {
    root = null;
    size = 0;
    modCount++;
    Node<K, V> header = this.header;
    header.next = header.prev = header;
  }

  public Set<Entry<K, V>> entrySet() {
    throw new java.lang.Error();
  }

  static final class Node<K, V> implements Entry<K, V> {

    Node<K, V> next;

    Node<K, V> prev;

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
