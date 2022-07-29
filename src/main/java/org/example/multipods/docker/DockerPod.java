package org.example.multipods;

public class DockerPod extends Pod {
  public DockerPod() {

  }

  @Override
  public void run() {
    System.out.println("Run DockerPod");
  }
}
