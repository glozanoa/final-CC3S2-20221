package org.example.multipods.podman;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.example.multipods.Pod;
import org.example.multipods.PodImage;

/**
 * Implementación de la clase abstracta Pod para Podman
 */
public class PodmanPod extends Pod {

  public PodmanPod(PodImage image) {
    super(image);
  }

  @Override
  public void create(Callback callback) {
    System.out.println("Creating podman pod");

    RequestBody requestBody = new FormBody.Builder()
            .add("image", image.toString())
            .build();

    Request request = new Request.Builder()
            .post(requestBody)
            .url("http://d/v1.0.0/libpod/containers/create")
            .build();

    apiConsumer.executeRequest(request, callback);
  }
}
