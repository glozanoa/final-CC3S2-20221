package org.example.multipods.docker;

import java.io.IOException;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.example.multipods.Pod;
import org.example.multipods.PodImage;

/**
 * Class DockerPod .
 */
public class DockerPod extends Pod {

  public DockerPod(PodImage image) {
    super(image);
  }

  @Override
  public void create(Callback callback) {
    System.out.println("Creating docker pod");

    RequestBody requestBody = new FormBody.Builder()
        .add("Image", image.toString())
        .build();

    Request request = new Request.Builder()
            .post(requestBody)
            .url(apiConsumer.getUrl() + "/v1.41/containers/create")
            .build();

    apiConsumer.executeRequest(request, callback);
  }
}
