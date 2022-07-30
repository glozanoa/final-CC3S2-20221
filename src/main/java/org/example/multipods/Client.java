package org.example.multipods;

import org.example.multipods.docker.DockerFactory;

public class Client {

  public static void main(String[] args){
    PodManager podManager = PodManager.getInstance();

    String mongoPodId = podManager.runController(new DockerFactory(), "mongo", "5.0");

  }
}
