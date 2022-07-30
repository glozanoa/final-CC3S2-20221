package org.example.multipods;

//import java.lang.*;


import java.io.InputStream;
import java.net.SocketAddress;

import okhttp3.*;
import org.newsclub.net.unix.AFSocketFactory;
import org.newsclub.net.unix.AFUNIXSocketAddress;
//import org.newsclub.net.unix.demo.DemoHelper;
//import org.newsclub.net.unix.jetty.AFSocketClientConnector;

//import com.kohlschutter.util.IOUtil;

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
        .socketFactory(new AFSocketFactory.FixedAddressSocketFactory(addr))
        .callTimeout(Duration.ofMinutes(1));

    OkHttpClient client = builder.build();

/*
    RequestBody body = new FormBody.Builder()
        .add("fromImage", "php:8.0-rc-buster")
        .build();
*/
    Request request = new Request.Builder()
        .url("http://localhost/v1.41/images/json")
        .build();

    Response response = client.newCall(request).execute();

    System.out.println(response.body().string());

    System.out.println("Hello world!");
  }
}