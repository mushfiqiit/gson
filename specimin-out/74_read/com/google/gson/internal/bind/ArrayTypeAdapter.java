package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public final class ArrayTypeAdapter<E> extends TypeAdapter<Object> {

    private final Class<E> componentType = null;

    private final TypeAdapter<E> componentTypeAdapter = null;

    public Object read(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        ArrayList<E> list = new ArrayList<>();
        in.beginArray();
        while (in.hasNext()) {
            E instance = componentTypeAdapter.read(in);
            list.add(instance);
        }
        in.endArray();
        int size = list.size();
        if (componentType.isPrimitive()) {
            Object array = Array.newInstance(componentType, size);
            for (int i = 0; i < size; i++) {
                Array.set(array, i, list.get(i));
            }
            return array;
        } else {
            @SuppressWarnings("unchecked")
            E[] array = (E[]) Array.newInstance(componentType, size);
            return list.toArray(array);
        }
    }
}
