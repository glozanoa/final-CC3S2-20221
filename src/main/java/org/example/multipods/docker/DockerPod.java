package org.example.multipods.docker;

import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.example.multipods.Pod;
import org.example.multipods.PodImage;

import java.io.IOException;

public class DockerPod extends Pod {
  private DockerApiConsumer apiClient;
  private RequestBody requestBody;

  public DockerPod(PodImage image) {
    super(image);
    requestBody = new FormBody.Builder()
            .add("Image", image.toString())
            .build();
  }

  @Override
  public String run() {
    return "Run DockerPod";
  }

  @Override
  public void create() throws IOException {
    Request request = new Request.Builder()
            .post(requestBody)
            .url(apiClient.getUrl() + "/v1.41/containers/create")
            .build();
    apiClient.executeRequest(request);
  }
}
