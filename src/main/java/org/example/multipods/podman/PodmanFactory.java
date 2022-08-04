package org.example.multipods.podman;

import org.example.multipods.ApiConsumer;
import org.example.multipods.ContainerFactory;
import org.example.multipods.Pod;
import org.example.multipods.PodImage;
import org.example.multipods.docker.DockerApiConsumer;

import java.net.SocketException;

public class PodmanFactory implements ContainerFactory {

  @Override
  public Pod createPod(PodImage image) {
    PodmanPod pod = new PodmanPod(image);
    pod.setApiConsumer(createApiConsumer());

    return pod;
  }

  @Override
  public PodImage createImage(String name, String tag) {
    PodmanImage image = new PodmanImage(name, tag);
    image.setApiConsumer(createApiConsumer());

    return image;
  }

  @Override
  public ApiConsumer createApiConsumer() {
    PodmanApiConsumer apiConsumer = null;
    try {
      apiConsumer = new PodmanApiConsumer();
    } catch (SocketException error) {
      System.err.println(error);
    }

    return apiConsumer;
  }
}
