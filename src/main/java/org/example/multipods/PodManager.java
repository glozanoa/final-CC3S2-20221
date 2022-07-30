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

  public static PodManager getInstance() {
    if (instance == null) {
      instance = new PodManager();
    }
    return instance;
  }

  public String runController(ContainerFactory factory, String image, String tag) {
    System.out.println("Running PodManager.runController( factory: " + factory.getClass() + ", image: " + image + ":" + tag);
    PodImage podImage = factory.createImage(image, tag);
    Pod pod = factory.createPod(podImage);

    PodController podController = new PodController(pod);

    System.out.println("podController: " + podController.toString());

    String podControllerId = podController.run();
    controllers.put(podControllerId, podController);

    return podControllerId;
  }

  public void exec(String podId, String cmd){
    // search pod by podId and execute cmd
  }
}
