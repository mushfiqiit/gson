package com.google.gson.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Set;

@SuppressWarnings("serial")
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {

  int size;

  int modCount;

  void removeInternal(Node<K, V> node, boolean unlink) {
    if (unlink) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }
    Node<K, V> left = node.left;
    Node<K, V> right = node.right;
    Node<K, V> originalParent = node.parent;
    if (left != null && right != null) {
      Node<K, V> adjacent = (left.height > right.height) ? left.last() : right.first();
      removeInternal(adjacent, false);
      int leftHeight = 0;
      left = node.left;
      if (left != null) {
        leftHeight = left.height;
        adjacent.left = left;
        left.parent = adjacent;
        node.left = null;
      }
      int rightHeight = 0;
      right = node.right;
      if (right != null) {
        rightHeight = right.height;
        adjacent.right = right;
        right.parent = adjacent;
        node.right = null;
      }
      adjacent.height = Math.max(leftHeight, rightHeight) + 1;
      replaceInParent(node, adjacent);
      return;
    } else if (left != null) {
      replaceInParent(node, left);
      node.left = null;
    } else if (right != null) {
      replaceInParent(node, right);
      node.right = null;
    } else {
      replaceInParent(node, null);
    }
    rebalance(originalParent, false);
    size--;
    modCount++;
  }

  @SuppressWarnings("ReferenceEquality")
  private void replaceInParent(Node<K, V> node, Node<K, V> replacement) {
    throw new java.lang.Error();
  }

  private void rebalance(Node<K, V> unbalanced, boolean insert) {
    throw new java.lang.Error();
  }

  public Set<Entry<K, V>> entrySet() {
    throw new java.lang.Error();
  }

  static final class Node<K, V> implements Entry<K, V> {

    Node<K, V> parent;

    Node<K, V> left;

    Node<K, V> right;

    Node<K, V> next;

    Node<K, V> prev;

    int height;

    public K getKey() {
      throw new java.lang.Error();
    }

    public V getValue() {
      throw new java.lang.Error();
    }

    public V setValue(V value) {
      throw new java.lang.Error();
    }

    public Node<K, V> first() {
      throw new java.lang.Error();
    }

    public Node<K, V> last() {
      throw new java.lang.Error();
    }
  }
}
