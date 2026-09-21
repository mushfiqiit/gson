package com.google.gson.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;

@SuppressWarnings("serial")
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {

  private final Comparator<? super K> comparator = null;

  private final boolean allowNullValues = false;

  Node<K, V> root;

  int size;

  int modCount;

  final Node<K, V> header = null;

  public LinkedTreeMap() {
    this(null, true);
  }

  public LinkedTreeMap(Comparator<? super K> comparator, boolean allowNullValues) {
    throw new java.lang.Error();
  }

  private EntrySet entrySet;

  private KeySet keySet;

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
