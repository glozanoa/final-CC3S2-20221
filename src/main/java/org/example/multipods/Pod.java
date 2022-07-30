package org.example.multipods;

import java.io.IOException;

public abstract class Pod {
  protected PodImage image;

  public Pod(PodImage image) {
    this.image = image;
  }

  public abstract String run();

  public abstract void create() throws IOException;

  public void exec(String cmd) {
    ;
  }

  public void pullPodImage() {
    ;
  }
}
