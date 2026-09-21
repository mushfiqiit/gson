package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.util.regex.Pattern;

public final class TypeAdapters {

  public static final TypeAdapter<InetAddress> INET_ADDRESS =
      new TypeAdapter<InetAddress>() {

        private final Pattern ipAddressPattern = Pattern.compile(".*:.*|[0-9]+(\\.[0-9]+){3}");

        public InetAddress read(JsonReader in) throws IOException {
          if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
          }
          String s = in.nextString();
          if (!ipAddressPattern.matcher(s).matches()
              && !Boolean.getBoolean("gson.allowDnsInetAddress")) {
            throw new JsonSyntaxException(
                "Failed parsing '"
                    + s
                    + "' as InetAddress; at path "
                    + in.getPreviousPath()
                    + "; to allow DNS addresses, set system property gson.allowDnsInetAddress to"
                    + " \"true\"");
          }
          @SuppressWarnings("AddressSelection")
          InetAddress addr = InetAddress.getByName(s);
          return addr;
        }

        public void write(JsonWriter out, InetAddress value) throws IOException {
          out.value(value == null ? null : value.getHostAddress());
        }
      };
}
