package org.example.multipods.podman;

import org.example.multipods.ContainerFactory;
import org.example.multipods.Pod;
import org.example.multipods.PodImage;

public class PodmanFactory implements ContainerFactory {

  @Override
  public Pod createPod(PodImage image) {
    return new PodmanPod(image);
  }

  @Override
  public PodImage createImage(String name, String tag) {
    return new PodmanImage(name, tag);
  }
}
