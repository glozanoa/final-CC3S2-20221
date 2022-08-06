package org.example.multipods;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.multipods.docker.DockerFactory;
import org.example.multipods.docker.DockerImage;
import org.example.multipods.docker.DockerPod;
import org.example.multipods.podman.PodmanFactory;
import org.example.multipods.podman.PodmanImage;
import org.example.multipods.podman.PodmanPod;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class PodManagerTest {
  private PodManager podManager;
  private ContainerFactory factory;
  private String image;
  private String tag;
  private Pod pod;
  private PodImage podImage;

  @BeforeEach
  public void getPodManager() {
    podManager = PodManager.getInstance();
    image = "mongo";
    tag = "5.0";
  }

  public void createImageAndPod(ContainerFactory containerFactory) {
    podImage = containerFactory.createImage(image, tag);
    pod = containerFactory.createPod(podImage);
  }

  // Test for AC1.1
  @Test
  public void dockerFactoryTest() {
    factory = new DockerFactory();
    createImageAndPod(factory);

    assertEquals(DockerImage.class, podImage.getClass());
    assertEquals(DockerPod.class, pod.getClass());
  }

  // Test for AC1.2
  @Test
  public void podmanFactoryTest() {
    factory = new PodmanFactory();
    createImageAndPod(factory);

    assertEquals(PodmanImage.class, podImage.getClass());
    assertEquals(PodmanPod.class, pod.getClass());
  }



}