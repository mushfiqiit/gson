package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.GsonTypes;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Map;

public final class MapTypeAdapterFactory implements TypeAdapterFactory {

    private final ConstructorConstructor constructorConstructor = null;

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        if (!Map.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type[] keyAndValueTypes = GsonTypes.getMapKeyAndValueTypes(type, rawType);
        Type keyType = keyAndValueTypes[0];
        Type valueType = keyAndValueTypes[1];
        TypeAdapter<?> keyAdapter = getKeyAdapter(gson, keyType);
        TypeAdapter<?> wrappedKeyAdapter = new TypeAdapterRuntimeTypeWrapper<>(gson, keyAdapter, keyType);
        TypeAdapter<?> valueAdapter = gson.getAdapter(TypeToken.get(valueType));
        TypeAdapter<?> wrappedValueAdapter = new TypeAdapterRuntimeTypeWrapper<>(gson, valueAdapter, valueType);
        boolean allowUnsafe = false;
        ObjectConstructor<T> constructor = constructorConstructor.get(typeToken, allowUnsafe);
        @SuppressWarnings({ "unchecked", "rawtypes" })
        TypeAdapter<T> result = new Adapter(wrappedKeyAdapter, wrappedValueAdapter, constructor);
        return result;
    }

    private TypeAdapter<?> getKeyAdapter(Gson context, Type keyType) {
        throw new java.lang.Error();
    }

    private final class Adapter<K, V> extends TypeAdapter<Map<K, V>> {

        Adapter(TypeAdapter<K> keyTypeAdapter, TypeAdapter<V> valueTypeAdapter, ObjectConstructor<? extends Map<K, V>> constructor) {
            throw new java.lang.Error();
        }
    }
}
