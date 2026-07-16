package com.google.gson;

public enum FieldNamingPolicy {
    ;

    static String upperCaseFirstLetter(String s) {
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    return s;
                }
                char uppercased = Character.toUpperCase(c);
                if (i == 0) {
                    return uppercased + s.substring(1);
                } else {
                    return s.substring(0, i) + uppercased + s.substring(i + 1);
                }
            }
        }
        return s;
    }
}
