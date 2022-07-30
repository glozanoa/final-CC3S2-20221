package org.example.multipods;

public abstract class Pod {
  protected PodImage image;

  public Pod(PodImage image) {
    this.image = image;
  }

  public abstract String run();

  public void exec(String cmd) {
    ;
  }

  public void pullPodImage() {
    ;
  }
}
