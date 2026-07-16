package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {

    private final ConstructorConstructor constructorConstructor = null;

    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory = null;

    private static <M extends AccessibleObject & Member> void checkAccessible(Object object, M member) {
        throw new java.lang.Error();
    }

    private BoundField createBoundField(Gson context, Field field, Method accessor, String serializedName, TypeToken<?> fieldType, boolean serialize, boolean blockInaccessible) {
        boolean isPrimitive = Primitives.isPrimitive(fieldType.getRawType());
        int modifiers = field.getModifiers();
        boolean isStaticFinalField = Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers);
        JsonAdapter annotation = field.getAnnotation(JsonAdapter.class);
        TypeAdapter<?> mapped = null;
        if (annotation != null) {
            mapped = jsonAdapterFactory.getTypeAdapter(constructorConstructor, context, fieldType, annotation, false);
        }
        boolean jsonAdapterPresent = mapped != null;
        if (mapped == null) {
            mapped = context.getAdapter(fieldType);
        }
        @SuppressWarnings("unchecked")
        TypeAdapter<Object> typeAdapter = (TypeAdapter<Object>) mapped;
        TypeAdapter<Object> writeTypeAdapter;
        if (serialize) {
            writeTypeAdapter = jsonAdapterPresent ? typeAdapter : new TypeAdapterRuntimeTypeWrapper<>(context, typeAdapter, fieldType.getType());
        } else {
            writeTypeAdapter = typeAdapter;
        }
        return new BoundField(serializedName, field) {

            void write(JsonWriter writer, Object source) throws IOException, IllegalAccessException {
                if (blockInaccessible) {
                    if (accessor == null) {
                        checkAccessible(source, field);
                    } else {
                        checkAccessible(source, accessor);
                    }
                }
                Object fieldValue;
                if (accessor != null) {
                    try {
                        fieldValue = accessor.invoke(source);
                    } catch (InvocationTargetException e) {
                        String accessorDescription = ReflectionHelper.getAccessibleObjectDescription(accessor, false);
                        throw new JsonIOException("Accessor " + accessorDescription + " threw exception", e.getCause());
                    }
                } else {
                    fieldValue = field.get(source);
                }
                if (fieldValue == source) {
                    return;
                }
                writer.name(serializedName);
                writeTypeAdapter.write(writer, fieldValue);
            }

            void readIntoArray(JsonReader reader, int index, Object[] target) throws IOException, JsonParseException {
                Object fieldValue = typeAdapter.read(reader);
                if (fieldValue == null && isPrimitive) {
                    throw new JsonParseException("null is not allowed as value for record component '" + fieldName + "' of primitive type; at path " + reader.getPath());
                }
                target[index] = fieldValue;
            }

            void readIntoField(JsonReader reader, Object target) throws IOException, IllegalAccessException {
                Object fieldValue = typeAdapter.read(reader);
                if (fieldValue != null || !isPrimitive) {
                    if (blockInaccessible) {
                        checkAccessible(target, field);
                    } else if (isStaticFinalField) {
                        String fieldDescription = ReflectionHelper.getAccessibleObjectDescription(field, false);
                        throw new JsonIOException("Cannot set value of 'static final' " + fieldDescription);
                    }
                    field.set(target, fieldValue);
                }
            }
        };
    }

    abstract static class BoundField {

        final String serializedName = null;

        final Field field = null;

        final String fieldName = null;

        protected BoundField(String serializedName, Field field) {
            throw new java.lang.Error();
        }
    }
}
