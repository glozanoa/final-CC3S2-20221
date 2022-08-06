package org.example.multipods.docker;

import java.io.File;
import java.net.SocketException;
import org.example.multipods.ApiConsumer;
import org.newsclub.net.unix.AFUNIXSocketAddress;

/**
 * Implementación de ApiConsumer para la tecnología Docker.
 */
public class DockerApiConsumer extends ApiConsumer {

  public DockerApiConsumer() throws SocketException {
    super(AFUNIXSocketAddress.of(new File("/run/docker.sock")));
  }

}
