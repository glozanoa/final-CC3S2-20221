package org.example.multipods;

import okhttp3.*;
import org.newsclub.net.unix.AFSocketFactory;
import org.newsclub.net.unix.AFUNIXSocketAddress;

import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.SocketAddress;
import java.time.Duration;

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

  private OkHttpClient createClient(SocketAddress socket){
    return null;
  }

  public Response executeRequest(Request request) throws IOException {
    //client.newCall()

    System.out.println("===================== RESTRICTED ZONE =====================");

    SocketAddress addr = AFUNIXSocketAddress.of(new File("/run/docker.sock"));

    OkHttpClient.Builder builder = new OkHttpClient.Builder()
            .socketFactory(new AFSocketFactory.FixedAddressSocketFactory(addr))
            .callTimeout(Duration.ofMinutes(1));

    OkHttpClient localClient = builder.build();


    RequestBody body = new FormBody.Builder()
            .add("fromImage", "python")
            .add("tag", "3.7")
            .build();

    Request localRequest = new Request.Builder()
            .url("http://localhost/v1.41/images/json")
            //.post(body)
            .build();

    //Response response = client.newCall(request).execute();


    localClient.newCall(localRequest).execute();

    //return client.newCall(request).execute();
    return null;
  }

  public String getUrl(){
    return "http://" + ip ;
  }

}
