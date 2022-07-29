package org.example.multipods.docker;

import org.example.multipods.PodImage;

public class DockerImage extends PodImage {
  public DockerImage(String name, String tag) {
    super(name, tag);
  }

  @Override
  public void pull() {

  }
}
