package org.example.multipods;

public abstract class PodImage {
  private String name;
  private String tag;

  protected ApiConsumer apiConsumer;

  public PodImage(String name){
    this.name = name;
    this.tag = "latest";
  }

  public PodImage(String name, String tag) {
    this.name = name;
    this.tag = tag;
  }

  public abstract void pull();

  public void setApiConsumer(ApiConsumer apiConsumer){
    this.apiConsumer = apiConsumer;
  }

  @Override
  public String toString() {
    return this.name + this.tag; // python:3.10
  }
}
