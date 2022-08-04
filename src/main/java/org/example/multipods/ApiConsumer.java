package org.example.multipods;

import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.SocketAddress;
import java.time.Duration;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.newsclub.net.unix.AFSocketFactory;
import org.newsclub.net.unix.AFUNIXSocketAddress;

/**
 * Clase abstracta ApiConsumer.//
 */
public abstract class ApiConsumer {
  protected OkHttpClient client;
  private final String ip = "127.0.0.1";
  //private final int port = 80;

  public ApiConsumer() { }

  public ApiConsumer(SocketAddress socket) {
    OkHttpClient.Builder builder = new OkHttpClient.Builder()
            .socketFactory(new AFSocketFactory.FixedAddressSocketFactory(socket))
            .callTimeout(Duration.ofMinutes(1));

    client = builder.build();
  }

  public void executeRequest(Request request, Callback callback) {
    client.newCall(request).enqueue(callback);
  }

  public String getUrl() {
    return "http://" + ip;
  }

}
