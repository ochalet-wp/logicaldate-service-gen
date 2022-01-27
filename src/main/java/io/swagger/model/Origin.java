package io.swagger.model;

import java.util.Map;
import com.fasterxml.jackson.annotation.*;
public class Origin {
  private String contextName;
  private MetaDetails consequenceOf;

  @JsonProperty("context_name")
  public String getContextName() {
    return this.contextName;
  }

  public void setContextName(String contextName) {
    this.contextName = contextName;
  }

  @JsonProperty("consequence_of")
  public MetaDetails getConsequenceOf() {
    return this.consequenceOf;
  }

  public void setConsequenceOf(MetaDetails consequenceOf) {
    this.consequenceOf = consequenceOf;
  }

}