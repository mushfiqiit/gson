package com.google.gson;

@SuppressWarnings("MemberName")
public final class JsonIOException extends JsonParseException {

    public JsonIOException(String msg) {
        super(msg);
    }

    public JsonIOException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
