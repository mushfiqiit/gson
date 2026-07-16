package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {

    static final TypeAdapterFactory FACTORY = null;

    private static int calculateHashMapCapacity(int numMappings) {
        throw new java.lang.Error();
    }

    private final Map<String, T> nameToConstant;

    private final Map<String, T> stringToConstant;

    private final Map<T, String> constantToName;

    private EnumTypeAdapter(Class<T> classOfT) {
        try {
            Field[] fields = classOfT.getDeclaredFields();
            int constantCount = 0;
            for (Field f : fields) {
                if (f.isEnumConstant()) {
                    fields[constantCount++] = f;
                }
            }
            fields = Arrays.copyOf(fields, constantCount);
            int hashMapCapacity = calculateHashMapCapacity(constantCount);
            nameToConstant = new HashMap<>(hashMapCapacity);
            stringToConstant = new HashMap<>(hashMapCapacity);
            constantToName = new HashMap<>(hashMapCapacity);
            AccessibleObject.setAccessible(fields, true);
            for (Field constantField : fields) {
                @SuppressWarnings("unchecked")
                T constant = (T) constantField.get(null);
                String name = constant.name();
                String toStringVal = constant.toString();
                SerializedName annotation = constantField.getAnnotation(SerializedName.class);
                if (annotation != null) {
                    name = annotation.value();
                    for (String alternate : annotation.alternate()) {
                        nameToConstant.put(alternate, constant);
                    }
                }
                nameToConstant.put(name, constant);
                stringToConstant.put(toStringVal, constant);
                constantToName.put(constant, name);
            }
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }
}
