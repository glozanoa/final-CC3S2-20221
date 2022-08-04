package org.example.multipods.podman;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.example.multipods.PodImage;

public class PodmanImage extends PodImage {
  public PodmanImage(String name, String tag) {
    super(name, tag);
  }

  @Override
  public void pull(Callback callback) {
    System.out.println("Pulling podman image " + super.toString());

    RequestBody body = new FormBody.Builder()
            .add("reference", toString())
            .build();

    Request request = new Request.Builder()
            .url("http://localhost/v1.41/images/create")
            .post(body)
            .build();

    apiConsumer.executeRequest(request, callback);
  }
}
