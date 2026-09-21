package com.google.gson.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;

@SuppressWarnings("serial")
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {

  private final Comparator<? super K> comparator;

  private final boolean allowNullValues;

  Node<K, V> root;

  int size;

  int modCount;

  final Node<K, V> header;

  public LinkedTreeMap(Comparator<? super K> comparator, boolean allowNullValues) {
    this.comparator = comparator;
    this.allowNullValues = allowNullValues;
    this.header = new Node<>(allowNullValues);
  }

  private EntrySet entrySet;

  private KeySet keySet;

  public Set<Entry<K, V>> entrySet() {
    throw new java.lang.Error();
  }

  static final class Node<K, V> implements Entry<K, V> {

    Node(boolean allowNullValue) {
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

  class EntrySet extends AbstractSet<Entry<K, V>> {

    public int size() {
      throw new java.lang.Error();
    }

    public Iterator<Entry<K, V>> iterator() {
      throw new java.lang.Error();
    }
  }

  final class KeySet extends AbstractSet<K> {

    public int size() {
      throw new java.lang.Error();
    }

    public Iterator<K> iterator() {
      throw new java.lang.Error();
    }
  }
}
