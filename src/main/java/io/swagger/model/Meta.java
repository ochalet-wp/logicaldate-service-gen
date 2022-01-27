package io.swagger.model;

import java.util.Map;
import com.fasterxml.jackson.annotation.*;
public class Meta {
  private MetaDetails initiator;
  private Origin origin;

  @JsonProperty("initiator")
  public MetaDetails getInitiator() {
    return this.initiator;
  }

  public void setInitiator(MetaDetails initiator) {
    this.initiator = initiator;
  }

  @JsonProperty("origin")
  public Origin getOrigin() {
    return this.origin;
  }

  public void setOrigin(Origin origin) {
    this.origin = origin;
  }

}