package org.example.multipods;

public interface ContainerFactory {
  public void createPod(PodImage image);
  public void createImage(String name, String tag);
}
