package com.google.gson;

import com.google.errorprone.annotations.CanIgnoreReturnValue;

public final class GsonBuilder {

  String datePattern;

  int dateStyle;

  int timeStyle;

  @CanIgnoreReturnValue
  public GsonBuilder setDateFormat(int dateStyle, int timeStyle) {
    this.dateStyle = checkDateFormatStyle(dateStyle);
    this.timeStyle = checkDateFormatStyle(timeStyle);
    this.datePattern = null;
    return this;
  }

  private static int checkDateFormatStyle(int style) {
    throw new java.lang.Error();
  }
}
