package org.example.multipods.docker;

import okhttp3.FormBody;
import okhttp3.RequestBody;
import org.example.multipods.Pod;
import org.example.multipods.PodImage;

public class DockerPod extends Pod {
  private DockerApiConsumer client;
  private RequestBody requestBody;

  public DockerPod(PodImage image) {
    super(image);
  }

  @Override
  public void run() {
    System.out.println("Run DockerPod");
  }

  @Override
  public void create() {
    requestBody = new FormBody.Builder()
            .add("Image", image.toString())
            .build();
  }
}
