package org.example.multipods.podman;

import java.io.File;
import java.net.SocketException;
import org.example.multipods.ApiConsumer;
import org.newsclub.net.unix.AFUNIXSocketAddress;

/**
 * Implementación de ApiConsumer para la tecnología Podman.
 */
public class PodmanApiConsumer extends ApiConsumer {

  public PodmanApiConsumer() throws SocketException {
    super(AFUNIXSocketAddress.of(new File("/run/podman/podman.sock")));
  }

}