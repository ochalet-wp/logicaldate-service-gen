package io.swagger.model;

import java.util.Map;
import com.fasterxml.jackson.annotation.*;
public class Details {
  private Map<String, Object> additionalProperties;

  public Map<String, Object> getAdditionalProperties() { return this.additionalProperties; }
  public void setAdditionalProperties(Map<String, Object> additionalProperties) { this.additionalProperties = additionalProperties; }
}