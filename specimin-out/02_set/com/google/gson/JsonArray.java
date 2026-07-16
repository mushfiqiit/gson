package com.google.gson;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.Iterator;

public final class JsonArray extends JsonElement {

    private final ArrayList<JsonElement> elements = null;

    @CanIgnoreReturnValue
    public JsonElement set(int index, JsonElement element) {
        return elements.set(index, element == null ? JsonNull.INSTANCE : element);
    }

    public Iterator<JsonElement> iterator() {
        throw new java.lang.Error();
    }
}
