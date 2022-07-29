package org.example.multipods;

public class PodController {
  private Pod pod;

  public PodController(Pod pod) {
    this.pod = pod;
  }

  public void run() {
    pod.run();
  }

  public void exec(String cmd) {
    pod.exec(cmd);
  }
}
