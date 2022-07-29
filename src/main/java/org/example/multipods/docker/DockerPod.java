package org.example.multipods.docker;

import org.example.multipods.Pod;
import org.example.multipods.PodImage;

public class DockerPod extends Pod {
  public DockerPod(PodImage image) {
    super(image);
  }

  @Override
  public void run() {
    System.out.println("Run DockerPod");
  }
}
