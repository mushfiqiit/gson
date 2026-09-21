package com.google.gson;

import com.google.gson.internal.GsonBuildConfig;
import com.google.gson.internal.Primitives;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.EOFException;
import java.io.IOException;

public final class Gson {

  final Strictness strictness = null;

  public <T> TypeAdapter<T> getAdapter(TypeToken<T> type) {
    throw new java.lang.Error();
  }

  public <T> T fromJson(JsonReader reader, TypeToken<T> typeOfT)
      throws JsonIOException, JsonSyntaxException {
    boolean isEmpty = true;
    Strictness oldStrictness = reader.getStrictness();
    if (this.strictness != null) {
      reader.setStrictness(this.strictness);
    } else if (reader.getStrictness() == Strictness.LEGACY_STRICT) {
      reader.setStrictness(Strictness.LENIENT);
    }
    try {
      JsonToken unused = reader.peek();
      isEmpty = false;
      TypeAdapter<T> typeAdapter = getAdapter(typeOfT);
      T object = typeAdapter.read(reader);
      Class<?> expectedTypeWrapped = Primitives.wrap(typeOfT.getRawType());
      if (object != null && !expectedTypeWrapped.isInstance(object)) {
        throw new ClassCastException(
            "Type adapter '"
                + typeAdapter
                + "' returned wrong type; requested "
                + typeOfT.getRawType()
                + " but got instance of "
                + object.getClass()
                + "\nVerify that the adapter was registered for the correct type.");
      }
      return object;
    } catch (EOFException e) {
      if (isEmpty) {
        return null;
      }
      throw new JsonSyntaxException(e);
    } catch (IllegalStateException e) {
      throw new JsonSyntaxException(e);
    } catch (IOException e) {
      throw new JsonSyntaxException(e);
    } catch (AssertionError e) {
      throw new AssertionError(
          "AssertionError (GSON " + GsonBuildConfig.VERSION + "): " + e.getMessage(), e);
    } finally {
      reader.setStrictness(oldStrictness);
    }
  }
}
