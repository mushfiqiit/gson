package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.util.Collection;

public final class CollectionTypeAdapterFactory implements TypeAdapterFactory {

  private static final class Adapter<E> extends TypeAdapter<Collection<E>> {

    private final TypeAdapter<E> elementTypeAdapter = null;

    private final ObjectConstructor<? extends Collection<E>> constructor = null;

    public Collection<E> read(JsonReader in) throws IOException {
      if (in.peek() == JsonToken.NULL) {
        in.nextNull();
        return null;
      }
      Collection<E> collection = constructor.construct();
      in.beginArray();
      while (in.hasNext()) {
        E instance = elementTypeAdapter.read(in);
        collection.add(instance);
      }
      in.endArray();
      return collection;
    }
  }
}
