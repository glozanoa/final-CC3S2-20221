package org.example.multipods;

public interface ContainerFactory {
  public Pod createPod(PodImage image);

  public PodImage createImage(String name, String tag);
}
