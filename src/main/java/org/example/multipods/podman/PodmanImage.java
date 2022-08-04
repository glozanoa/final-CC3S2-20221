package org.example.multipods.podman;

import okhttp3.Callback;
import org.example.multipods.PodImage;

public class PodmanImage extends PodImage {
  public PodmanImage(String name, String tag) {
    super(name, tag);
  }

  @Override
  public void pull(Callback callback){

  }
}
