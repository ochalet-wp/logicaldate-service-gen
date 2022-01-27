package io.swagger.model;

import com.fasterxml.jackson.annotation.*;
public enum Category {
  COMMAND("command"), EVENT("event");

  private String value;

  Category(String value) {
    this.value = value;
  }
    
  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static Category fromValue(String value) {
    for (Category e : Category.values()) {
      if (e.value.equals(value)) {
        return e;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}