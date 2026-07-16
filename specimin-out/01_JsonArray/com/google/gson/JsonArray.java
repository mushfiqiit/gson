package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;

public final class JsonArray extends JsonElement {

    private final ArrayList<JsonElement> elements;

    @SuppressWarnings("deprecation")
    public JsonArray(int capacity) {
        elements = new ArrayList<>(capacity);
    }

    public Iterator<JsonElement> iterator() {
        throw new java.lang.Error();
    }
}
