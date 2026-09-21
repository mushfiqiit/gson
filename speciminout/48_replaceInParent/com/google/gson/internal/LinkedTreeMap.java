package com.google.gson.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Set;

@SuppressWarnings("serial")
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {

  Node<K, V> root;

  @SuppressWarnings("ReferenceEquality")
  private void replaceInParent(Node<K, V> node, Node<K, V> replacement) {
    Node<K, V> parent = node.parent;
    node.parent = null;
    if (replacement != null) {
      replacement.parent = parent;
    }
    if (parent != null) {
      if (parent.left == node) {
        parent.left = replacement;
      } else {
        assert parent.right == node;
        parent.right = replacement;
      }
    } else {
      root = replacement;
    }
  }

  public Set<Entry<K, V>> entrySet() {
    throw new java.lang.Error();
  }

  static final class Node<K, V> implements Entry<K, V> {

    Node<K, V> parent;

    Node<K, V> left;

    Node<K, V> right;

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
