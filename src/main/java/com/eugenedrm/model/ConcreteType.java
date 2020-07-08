package com.eugenedrm.model;

public enum ConcreteType {
  TYPE_A("Type A"),
  TYPE_B("Type B");

  private final String name;

  ConcreteType(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
