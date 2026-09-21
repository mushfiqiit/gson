package com.google.gson;

import com.google.errorprone.annotations.CanIgnoreReturnValue;

public final class GsonBuilder {

  String datePattern;

  int dateStyle;

  @Deprecated
  @CanIgnoreReturnValue
  public GsonBuilder setDateFormat(int dateStyle) {
    this.dateStyle = checkDateFormatStyle(dateStyle);
    this.datePattern = null;
    return this;
  }

  private static int checkDateFormatStyle(int style) {
    throw new java.lang.Error();
  }
}
