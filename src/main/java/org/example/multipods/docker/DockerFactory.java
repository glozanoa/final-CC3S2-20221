package org.example.multipods.docker;

import org.example.multipods.ContainerFactory;
import org.example.multipods.PodImage;

public class DockerFactory extends DockerImage implements ContainerFactory {

  public DockerFactory(String name, String tag) {
    super(name, tag);
  }

  @Override
  public void createPod(PodImage image) {

  }

  @Override
  public void createImage(String name, String tag) {

  }
}
