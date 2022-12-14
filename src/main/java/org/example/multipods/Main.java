package org.example.multipods;

import java.io.File;
import java.io.IOException;
import java.net.SocketAddress;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.newsclub.net.unix.AFSocketFactory;
import org.newsclub.net.unix.AFUNIXSocketAddress;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


/**
 * Main class .
 */
public class Main {
  public static void main(String[] args) throws IOException {

    SocketAddress addr = AFUNIXSocketAddress.of(new File("/var/run/docker.sock"));

    OkHttpClient.Builder builder = new OkHttpClient.Builder()
        .socketFactory(new AFSocketFactory.FixedAddressSocketFactory(addr));

    OkHttpClient client = builder.build();


    RequestBody body = new FormBody.Builder()
        .add("fromImage", "python")
            .add("tag", "3.7-alpine3.15")
        .build();

    Request request = new Request.Builder()
        .url("http://localhost/v1.41/images/create")
        .post(body)
        .build();

    Callback callback = new Callback() {
      @Override
      public void onFailure(Call call, IOException e) {
        System.out.println("(FAILURE) Call: " + call.toString() + ", Exception: " + e.toString());
      }

      @Override
      public void onResponse(Call call, Response response) throws IOException {
        System.out.println("(ON RESPONSE Call: " + call.toString() + ", Response: " + response.toString());
      }
    };

    client.newCall(request).enqueue(callback);
  }
}
