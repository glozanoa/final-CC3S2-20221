package org.example.multipods.podman;

import org.example.multipods.Pod;
import org.example.multipods.PodImage;

public class PodmanPod extends Pod {
  public PodmanPod(PodImage image) {
    super(image);
  }

  @Override
  public void run() {
    System.out.println("Run PodmanPod");
  }
}
