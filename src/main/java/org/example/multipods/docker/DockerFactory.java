package org.example.multipods.docker;

import org.example.multipods.*;
import org.example.multipods.podman.PodmanImage;

public class DockerFactory implements ContainerFactory {

  @Override
  public Pod createPod(PodImage image) {
    return new DockerPod(image);
  }

  @Override
  public PodImage createImage(String name, String tag) {
    return new DockerImage(name, tag);
  }
}
