package org.example.multipods.docker;

public class DockerPod extends Pod {
  public DockerPod() {

  }

  @Override
  public void run() {
    System.out.println("Run DockerPod");
  }
}
