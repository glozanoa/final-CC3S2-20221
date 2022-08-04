package org.example.multipods;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * PodManages es una clase singleton que administra varios podControllers.
 */
public class PodManager {
  private static Map<String, PodController> controllers;
  private static PodManager instance = null;

  private PodManager() {
    controllers = new HashMap<String, PodController>();
    instance = this;
  }

  /**
   * Método que crea instancias PodManager (patrón de diseño singleton) .
   *
   * @return Retorna la instancia singleton
   */
  public static PodManager getInstance() {
    if (instance == null) {
      instance = new PodManager();
    }
    return instance;
  }

  public void pullPodImage(ContainerFactory factory, String image, String tag) {
    PodImage podImage = factory.createImage(image, tag);
    podImage.pull();
  }

  /**
   * Controlador de container .
   *
   * @param factory es el objeto fábrica que creará las imágenes y los contenedores
   * @param image es el nombre de la imagen que deseamos crear
   * @param tag es la versión de la imagen
   */
  public void runController(ContainerFactory factory, String image, String tag) {
    System.out.println("Running PodManager.runController( factory: "
            + factory.getClass() + ", image: " + image + ":" + tag);
    PodImage podImage = factory.createImage(image, tag);
    Pod pod = factory.createPod(podImage);

    PodController podController = new PodController(pod);

    System.out.println("podController: " + podController.toString());

    Callback callback = new Callback() {
      @Override
      public void onFailure(Call call, IOException e) {
        System.out.println("(ERROR) Call: " + call.toString() + "Error: " + e.toString());
      }

      @Override
      public void onResponse(Call call, Response response) throws IOException {
        String podId = Integer.toString(new Random().nextInt()); // get pod ID from Response
        controllers.put(podId, podController);
      }
    };

    podController.run(callback);
  }

  public void exec(String podId, String cmd){
    // search pod by podId and execute cmd
  }
}
