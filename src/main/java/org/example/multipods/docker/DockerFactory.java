package org.example.multipods.docker;

import org.example.multipods.*;
import org.example.multipods.podman.PodmanImage;

public class DockerFactory extends DockerImage implements ContainerFactory {

  public DockerFactory(String name, String tag) {
    super(name, tag);
  }

  @Override
  public Pod createPod(PodImage image) {
    return new DockerPod();
  }

  @Override
  public PodImage createImage(String name, String tag) {
    return new DockerImage(name, tag);
  }
}
