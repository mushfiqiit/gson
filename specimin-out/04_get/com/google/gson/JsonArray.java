package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;

public final class JsonArray extends JsonElement {

    private final ArrayList<JsonElement> elements = null;

    public Iterator<JsonElement> iterator() {
        throw new java.lang.Error();
    }

    public JsonElement get(int i) {
        return elements.get(i);
    }
}
