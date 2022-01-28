package io.swagger.model;

import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.annotation.*;
public class Details {
  private Map<String, String> additionalProperties;

  public Map<String, String> getAdditionalProperties() { return this.additionalProperties; }
  public void setAdditionalProperties(Map<String, String> additionalProperties) { this.additionalProperties = additionalProperties; }
}