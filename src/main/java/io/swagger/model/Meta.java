package io.swagger.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.*;
public class Meta {
  private MetaDetails initiator;
  private Origin origin;

  public Meta(String initiator){
    MetaDetails metaDetails  = new MetaDetails();
    metaDetails.setName("logical_date_service");
    Details details = new Details();
    Map<String,String> ids = new HashMap<>();
    ids.put("id",initiator);
    details.setAdditionalProperties(ids);
    metaDetails.setDetails(details);
    this.setInitiator(metaDetails);
  }

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