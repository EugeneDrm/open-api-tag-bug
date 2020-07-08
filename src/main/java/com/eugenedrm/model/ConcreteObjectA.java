package com.eugenedrm.model;

public class ConcreteObjectA extends AbstractObject {

  private final String description;

  public ConcreteObjectA(String name, String description) {
    super(ConcreteType.TYPE_A, name);
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}
