package org.example.multipods.docker;

import java.io.IOException;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.example.multipods.PodImage;

public class DockerImage extends PodImage {
  public DockerImage(String name, String tag) {
    super(name, tag);
  }

  @Override
  public void pull() {
    System.out.println("pulling docker image " + toString());
    RequestBody body = new FormBody.Builder()
        .add("fromImage", toString())
        .build();

    Request request = new Request.Builder()
            .url(apiConsumer.getUrl() + "v1.41/images/create")
            .post(body)
            .build();

    System.out.println("request: " + request.toString());

    try {
      System.out.println("apiConsumer: " + apiConsumer.toString());
      apiConsumer.executeRequest(request);
    } catch (IOException error) {
      System.err.println(error);
    }
  }
}
