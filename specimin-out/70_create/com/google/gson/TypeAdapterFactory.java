package com.google.gson;

import com.google.gson.reflect.TypeToken;

public interface TypeAdapterFactory {

    default <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        throw new java.lang.Error();
    }
}
