package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;

final class TypeAdapterRuntimeTypeWrapper<T> extends TypeAdapter<T> {

    TypeAdapterRuntimeTypeWrapper(Gson context, TypeAdapter<T> delegate, Type type) {
        throw new java.lang.Error();
    }

    public T read(JsonReader in) throws IOException {
        throw new java.lang.Error();
    }

    public void write(JsonWriter out, T value) throws IOException {
        throw new java.lang.Error();
    }
}
