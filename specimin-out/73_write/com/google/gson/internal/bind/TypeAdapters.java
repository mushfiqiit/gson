package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.List;

public final class TypeAdapters {

    abstract static class IntegerFieldsTypeAdapter<T> extends TypeAdapter<T> {

        private final List<String> fields = null;

        abstract long[] integerValues(T t);

        public void write(JsonWriter out, T value) throws IOException {
            if (value == null) {
                out.nullValue();
                return;
            }
            out.beginObject();
            long[] values = integerValues(value);
            for (int i = 0; i < fields.size(); i++) {
                out.name(fields.get(i));
                out.value(values[i]);
            }
            out.endObject();
        }
    }
}
