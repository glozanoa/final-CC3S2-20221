package org.example.multipods.docker;

import org.example.multipods.Pod;

public class DockerPod extends Pod {
  public DockerPod() {

  }

  @Override
  public void run() {
    System.out.println("Run DockerPod");
  }
}
