package org.example.multipods;

import java.io.IOException;

public abstract class Pod {
  protected PodImage image;
  protected ApiConsumer apiConsumer;

  public Pod(PodImage image) {
    this.image = image;
  }

  public void setApiConsumer(ApiConsumer apiConsumer){
    this.apiConsumer = apiConsumer;
  }

  public  String run(){
    System.out.println("(Pod.run) Running pod: " + toString());
    pullPodImage();
    return create();
  }

  public abstract String create();

  public void exec(String cmd) {
    ;
  }

  public void pullPodImage() {
    // check if image exist
    image.pull();
  }

  @Override
  public String toString() {
    return "Pod(image= " + image + ")";
  }
}
