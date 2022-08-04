package org.example.multipods.docker;

import java.net.SocketException;
import org.example.multipods.ApiConsumer;
import org.example.multipods.ContainerFactory;
import org.example.multipods.Pod;
import org.example.multipods.PodImage;
import org.example.multipods.podman.PodmanImage;

/**
 * Fábrica concreta que crea objetos con la tecnología Docker.
 */
public class DockerFactory implements ContainerFactory {

  @Override
  public Pod createPod(PodImage image) {
    DockerPod pod = new DockerPod(image);
    pod.setApiConsumer(createApiConsumer());

    return pod;
  }

  @Override
  public PodImage createImage(String name, String tag) {

    DockerImage image = new DockerImage(name, tag);
    image.setApiConsumer(createApiConsumer());

    return image;
  }

  @Override
  public ApiConsumer createApiConsumer()  {
    DockerApiConsumer apiConsumer = null;
    try {
      apiConsumer = new DockerApiConsumer();
    } catch (SocketException error) {
      System.err.println(error);
    }

    return apiConsumer;
  }
}
