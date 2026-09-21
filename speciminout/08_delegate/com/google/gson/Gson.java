package com.google.gson;

import com.google.gson.internal.bind.SerializationDelegatingTypeAdapter;

public final class Gson {

  static class FutureTypeAdapter<T> extends SerializationDelegatingTypeAdapter<T> {

    private TypeAdapter<T> delegate = null;
  }
}
