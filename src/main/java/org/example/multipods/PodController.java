package org.example.multipods;

import okhttp3.Callback;

/**
 * Controlador de pods.
 */
public class PodController {
  private Pod pod;

  public PodController(Pod pod) {
    this.pod = pod;
  }

  public void run(Callback callback) {
    pod.run(callback);
  }

  public void exec(String cmd) {
    pod.exec(cmd);
  }

  @Override
  public String toString() {
    return "PodController(pod=" + pod  + ")";
  }
}
