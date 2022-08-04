package org.example.multipods;

import org.example.multipods.docker.DockerFactory;
import org.example.multipods.podman.PodmanFactory;

public class Client {

  public static void main(String[] args){
    PodManager podManager = PodManager.getInstance();

    podManager.pullPodImage(new PodmanFactory(), "python", "3.9-bullseye");
    //podManager.runController(new DockerFactory(), "mongo", "5.0");

  }
}
