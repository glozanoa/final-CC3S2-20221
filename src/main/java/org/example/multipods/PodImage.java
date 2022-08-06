package org.example.multipods;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * CLase abstracta que se encarga del manejo de imágenes.
 */
public abstract class PodImage {
  private String name;
  private String tag;

  protected ApiConsumer apiConsumer;

  public PodImage(String name) {
    this.name = name;
    this.tag = "latest";
  }

  public PodImage(String name, String tag) {
    this.name = name;
    this.tag = tag;
  }

  /**
   * Método que maneja la descarga de imágenes.
   */
  public void pull() {
    Callback emptyCallback = new Callback() {
      @Override
      public void onFailure(Call call, IOException e) {

      }

      @Override
      public void onResponse(Call call, Response response) throws IOException {

      }
    };
    pull(emptyCallback);
  }

  public abstract void pull(Callback callback);

  public void setApiConsumer(ApiConsumer apiConsumer) {
    this.apiConsumer = apiConsumer;
  }

  public String getName() {
    return name;
  }

  public String getTag() {
    return tag;
  }

  @Override
  public String toString() {
    return this.name + ":" + this.tag; // python:3.10
  }
}
