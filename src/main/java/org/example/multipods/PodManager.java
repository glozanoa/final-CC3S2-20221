package org.example;

import java.awt.*;
import java.util.HashMap;

public class PodManager {
  private static Map<String, PodController> controllers;
  private static PodManager instance = null;

  private PodManager(){
    controllers = new HashMap<String, PodController>();
    instance = this;
  }

  public PodManager getInstance(){
    if(instance == null){
      instance = new PodManager();
    }
    return instance;
  }

  public String createController(ContainerFactory factory, String image, String tag){

  }

  public void exec()
}
