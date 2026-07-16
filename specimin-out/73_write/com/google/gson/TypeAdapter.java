package com.google.gson;

import com.google.gson.stream.JsonWriter;
import java.io.IOException;

public abstract class TypeAdapter<T> {

    public abstract void write(JsonWriter out, T value) throws IOException;
}
