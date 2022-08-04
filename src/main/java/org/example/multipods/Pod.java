package org.example.multipods;

import java.io.IOException;
import java.util.Random;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public abstract class Pod {
  protected PodImage image;
  protected ApiConsumer apiConsumer;

  public Pod(PodImage image) {
    this.image = image;
  }

  public void setApiConsumer(ApiConsumer apiConsumer) {
    this.apiConsumer = apiConsumer;
  }

  public  void run(Callback callback) {
    System.out.println("(Pod.run) Running pod: " + toString());

    Callback pullCallback = new Callback() {
      @Override
      public void onFailure(Call call, IOException e) {
        System.out.println("(ERROR) Call: " + call.toString() + "Error: " + e.toString());
      }

      @Override
      public void onResponse(Call call, Response response) throws IOException {
        //create(callback);
        System.out.println("(ON RESPONSE) Call: " + call.toString()
                + ", Response: " + response.toString());
      }
    };

    pullPodImage(pullCallback);
  }

  public abstract void create(Callback callback);

  public void exec(String cmd) {
    ;
  }

  public void pullPodImage(Callback callback) {
    image.pull(callback);
  }

  @Override
  public String toString() {
    return "Pod(image= " + image + ")";
  }
}
