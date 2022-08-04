package org.example.multipods.docker;


import okhttp3.*;
import org.example.multipods.PodImage;

public class DockerImage extends PodImage {
  public DockerImage(String name, String tag) {
    super(name, tag);
  }


  @Override
  public void pull(Callback callback) {
    System.out.println("Pulling docker image " + super.toString());
    RequestBody body = new FormBody.Builder()
            .add("fromImage", getName())
            .add("tag", getTag())
            .build();

    Request request = new Request.Builder()
        .url("http://localhost/v1.41/images/create")
        .post(body)
        .build();

    apiConsumer.executeRequest(request, callback);

  }
}
