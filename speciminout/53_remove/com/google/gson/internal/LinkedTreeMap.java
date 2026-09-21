package com.google.gson.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Set;

@SuppressWarnings("serial")
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {

  int modCount;

  void removeInternal(Node<K, V> node, boolean unlink) {
    throw new java.lang.Error();
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

  private abstract class LinkedTreeMapIterator<T> implements Iterator<T> {

    Node<K, V> lastReturned;

    int expectedModCount;

    @SuppressWarnings("ReferenceEquality")
    public final boolean hasNext() {
      throw new java.lang.Error();
    }

    public final void remove() {
      if (lastReturned == null) {
        throw new IllegalStateException();
      }
      removeInternal(lastReturned, true);
      lastReturned = null;
      expectedModCount = modCount;
    }
  }
}
