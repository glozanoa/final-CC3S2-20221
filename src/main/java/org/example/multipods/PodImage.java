package org.example.multipods;

public abstract class PodImage {
  String name;
  String tag;

  public PodImage(String name){
    this.name = name;
    this.tag = "latest";
  }
  public PodImage(String name, String tag) {
    this.name = name;
    this.tag = tag;
  }

  public void pull() {}
}
