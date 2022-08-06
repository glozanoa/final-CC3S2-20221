package org.example.multipods;

/**
 * Interface ContainerFactory que contiene los métodos creación de objetos abstractos.
 * independiente de la tecnología a usar.
 */
public interface ContainerFactory {
  public Pod createPod(PodImage image);

  public PodImage createImage(String name, String tag);

  public ApiConsumer createApiConsumer();
}
