package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.util.List;

public final class TypeAdapters {

    abstract static class IntegerFieldsTypeAdapter<T> extends TypeAdapter<T> {

        private final List<String> fields = null;

        abstract T create(long[] values);

        public T read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            in.beginObject();
            long[] values = new long[fields.size()];
            while (in.peek() != JsonToken.END_OBJECT) {
                String name = in.nextName();
                int index = fields.indexOf(name);
                if (index >= 0) {
                    values[index] = in.nextLong();
                } else {
                    in.skipValue();
                }
            }
            in.endObject();
            return create(values);
        }
    }
}
