package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import java.text.DateFormat;
import java.util.Date;

public final class DefaultDateTypeAdapter<T extends Date> extends TypeAdapter<T> {

  public static final TypeAdapterFactory DEFAULT_STYLE_FACTORY =
      new TypeAdapterFactory() {

        @SuppressWarnings("unchecked")
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
          return typeToken.getRawType() == Date.class
              ? (TypeAdapter<T>)
                  new DefaultDateTypeAdapter<>(
                      DateType.DATE, DateFormat.DEFAULT, DateFormat.DEFAULT)
              : null;
        }

        public String toString() {
          return "DefaultDateTypeAdapter#DEFAULT_STYLE_FACTORY";
        }
      };

  public abstract static class DateType<T extends Date> {

    public static final DateType<Date> DATE = null;
  }

  private DefaultDateTypeAdapter(DateType<T> dateType, int dateStyle, int timeStyle) {
    throw new java.lang.Error();
  }
}
