package org.example.multipods.docker;

import okhttp3.OkHttpClient;
import org.example.multipods.ApiConsumer;
import org.newsclub.net.unix.AFUNIXSocketAddress;

import java.io.File;
import java.net.SocketAddress;
import java.net.SocketException;

public class DockerApiConsumer extends ApiConsumer {
  private OkHttpClient client;
  private final String ip = "127.0.0.1";
  private final int port = 80;


  public DockerApiConsumer() throws SocketException {
    super(AFUNIXSocketAddress.of(new File("/var/run/docker.sock")));
  }

}
