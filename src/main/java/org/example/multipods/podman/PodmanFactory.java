package org.example.multipods.podman;

import org.example.multipods.ContainerFactory;
import org.example.multipods.Pod;
import org.example.multipods.PodImage;
import org.example.multipods.PodmanPod;

public class PodmanFactory extends PodmanImage implements ContainerFactory {

  public PodmanFactory(String name, String tag) {
    super(name, tag);
  }

  @Override
  public Pod createPod(PodImage image) {
    return new PodmanPod();
  }

  @Override
  public PodImage createImage(String name, String tag) {
    return new PodmanImage(name, tag);
  }
}
