package org.example.multipods;

/**
 * Interface ContainerFactory .
 */
public interface ContainerFactory {
  public Pod createPod(PodImage image);

  public PodImage createImage(String name, String tag);

  public ApiConsumer createApiConsumer();
}
