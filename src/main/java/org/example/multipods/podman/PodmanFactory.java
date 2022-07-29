package org.example.multipods.podman;

import org.example.multipods.ContainerFactory;
import org.example.multipods.PodImage;

public class PodmanFactory extends PodmanImage implements ContainerFactory {
  public PodmanFactory(String name, String tag) {
    super(name, tag);
  }

  @Override
  public void createPod(PodImage image) {

  }

  @Override
  public void createImage(String name, String tag) {

  }
}
