package org.example.multipods;

import org.example.multipods.docker.DockerFactory;

public class Client {

  public static void main(String[] args) {
    PodManager podManager = PodManager.getInstance();

    //podManager.pullPodImage(new DockerFactory(), "python", "3.9-bullseye");
    podManager.runController(new DockerFactory(), "mongo", "5.0");

  }
}
