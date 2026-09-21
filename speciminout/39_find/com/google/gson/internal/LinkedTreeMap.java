package com.google.gson.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Set;

@SuppressWarnings("serial")
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {

  private final Comparator<? super K> comparator = null;

  private final boolean allowNullValues = false;

  Node<K, V> root;

  int size;

  int modCount;

  final Node<K, V> header = null;

  Node<K, V> find(K key, boolean create) {
    Comparator<? super K> comparator = this.comparator;
    Node<K, V> nearest = root;
    int comparison = 0;
    if (nearest != null) {
      @SuppressWarnings("unchecked")
      Comparable<Object> comparableKey = comparator == null ? (Comparable<Object>) key : null;
      while (true) {
        comparison =
            (comparableKey != null)
                ? comparableKey.compareTo(nearest.key)
                : comparator.compare(key, nearest.key);
        if (comparison == 0) {
          return nearest;
        }
        Node<K, V> child = (comparison < 0) ? nearest.left : nearest.right;
        if (child == null) {
          break;
        }
        nearest = child;
      }
    }
    if (!create) {
      return null;
    }
    Node<K, V> header = this.header;
    Node<K, V> created;
    if (nearest == null) {
      if (comparator == null && !(key instanceof Comparable)) {
        throw new ClassCastException(key.getClass().getName() + " is not Comparable");
      }
      created = new Node<>(allowNullValues, nearest, key, header, header.prev);
      root = created;
    } else {
      created = new Node<>(allowNullValues, nearest, key, header, header.prev);
      if (comparison < 0) {
        nearest.left = created;
      } else {
        nearest.right = created;
      }
      rebalance(nearest, true);
    }
    size++;
    modCount++;
    return created;
  }

  private void rebalance(Node<K, V> unbalanced, boolean insert) {
    throw new java.lang.Error();
  }

  public Set<Entry<K, V>> entrySet() {
    throw new java.lang.Error();
  }

  static final class Node<K, V> implements Entry<K, V> {

    Node<K, V> left;

    Node<K, V> right;

    Node<K, V> prev;

    final K key = null;

    Node(boolean allowNullValue, Node<K, V> parent, K key, Node<K, V> next, Node<K, V> prev) {
      throw new java.lang.Error();
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
