package org.example.multipods.podman;

import org.example.multipods.PodImage;

public class PodmanImage extends PodImage {
  public PodmanImage(String name, String tag) {
    super(name, tag);
  }

  @Override
  public void pull() { }
}
