package org.example.multipods.podman;

import org.example.multipods.Pod;

public class PodmanPod extends Pod {
  public PodmanPod() {
  }

  @Override
  public void run() {
    System.out.println("Run PodmanPod");
  }
}
