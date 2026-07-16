package com.google.gson;

import com.google.gson.stream.JsonReader;
import java.io.IOException;

public abstract class TypeAdapter<T> {

    public abstract T read(JsonReader in) throws IOException;
}
