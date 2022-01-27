package io.swagger.model;

import java.util.Map;
import com.fasterxml.jackson.annotation.*;
public class MetaDetails {
  private String name;
  private Details details;

  @JsonProperty("name")
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @JsonProperty("details")
  public Details getDetails() {
    return this.details;
  }

  public void setDetails(Details details) {
    this.details = details;
  }

}