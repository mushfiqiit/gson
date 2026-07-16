package com.google.gson.internal.bind.util;

@SuppressWarnings("MemberName")
public class ISO8601Utils {

    private static boolean checkOffset(String value, int offset, char expected) {
        return (offset < value.length()) && (value.charAt(offset) == expected);
    }
}
