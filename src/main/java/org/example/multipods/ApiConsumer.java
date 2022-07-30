package org.example.multipods;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.newsclub.net.unix.AFSocketFactory;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.SocketAddress;
import java.time.Duration;

public abstract class ApiConsumer {
  private OkHttpClient client;
  private final String ip = "127.0.0.1";
  private final int port = 80;

  public ApiConsumer() { }

  public ApiConsumer(SocketAddress socket) {
    client = new OkHttpClient.Builder()
            .socketFactory(new AFSocketFactory.FixedAddressSocketFactory(socket))
            .callTimeout(Duration.ofMinutes(1)).build();
  }

  public Response executeRequest(Request request) throws IOException {
    return client.newCall(request).execute();
  }

  public String getUrl(){
    return "http://" + ip + port + "/";
  }

}
