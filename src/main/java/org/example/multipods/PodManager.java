package org.example.multipods;

import java.util.HashMap;
import java.util.Map;

public class PodManager {
  private static Map<String, PodController> controllers;
  private static PodManager instance = null;

  private PodManager() {
    controllers = new HashMap<String, PodController>();
    instance = this;
  }

  public PodManager getInstance() {
    if (instance == null) {
      instance = new PodManager();
    }
    return instance;
  }

  public String createController(ContainerFactory factory, String image, String tag) {
    //PodImage podImage = factory.
    return null;
  }

  public void exec(String podId, String cmd){
    // search pod by podId and execute cmd
  }
}
