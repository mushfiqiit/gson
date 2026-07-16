package com.google.gson;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.Iterator;

public final class JsonArray extends JsonElement {

    private final ArrayList<JsonElement> elements = null;

    @CanIgnoreReturnValue
    public JsonElement remove(int index) {
        return elements.remove(index);
    }

    public Iterator<JsonElement> iterator() {
        throw new java.lang.Error();
    }
}
