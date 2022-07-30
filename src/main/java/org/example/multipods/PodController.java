package org.example.multipods;

public class PodController {
  private Pod pod;

  public PodController(Pod pod) {
    this.pod = pod;
  }

  public String run() {
    return pod.run();
  }

  public void exec(String cmd) {
    pod.exec(cmd);
  }

  @Override
  public String toString() {
    return "PodController(pod=" + pod  + ")";
  }
}
