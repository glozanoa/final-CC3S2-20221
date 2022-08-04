package org.example.multipods.docker;

import java.io.File;
import java.net.SocketAddress;
import java.net.SocketException;
import okhttp3.OkHttpClient;
import org.example.multipods.ApiConsumer;
import org.newsclub.net.unix.AFUNIXSocketAddress;

/**
 * Class DockerApiConsumer .
 */
public class DockerApiConsumer extends ApiConsumer {

  public DockerApiConsumer() throws SocketException {
    super(AFUNIXSocketAddress.of(new File("/run/docker.sock")));
  }

}
