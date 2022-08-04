package org.example.multipods.docker;

import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.example.multipods.PodImage;

import java.io.IOException;

public class DockerImage extends PodImage {
  public DockerImage(String name, String tag) {
    super(name, tag);
  }

  @Override
  public void pull() {
    System.out.println("pulling docker image " + super.toString());
    RequestBody body = new FormBody.Builder()
            .add("fromImage", getName())
            .add("tag", getTag())
            .build();

    Request request = new Request.Builder()
        .url("http://localhost/v1.41/images/create")
        .post(body)
        .build();

    System.out.println("request: " + request.toString());
    System.out.println("request body: "+ request.body().toString());

    try{
      System.out.println("apiConsumer: " + apiConsumer.toString());
      super.apiConsumer.executeRequest(request);
    }
    catch (IOException error){
      error.printStackTrace();
    }
  }
}
