package io.swagger.model;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.threetenbp.ser.OffsetDateTimeSerializer;
import org.threeten.bp.OffsetDateTime;

public class WpBasicLde {
  private String id;
  private String name;
  private Category category;
  private Integer version;
  private OffsetDateTime occurredAt;
  private Meta meta;
  private Lde payload;

  private static final String EVENT_NAME = "logical_date_changed";
  private static final int EVENT_VERSION = 1;

  public WpBasicLde(Integer key, Lde lde,UUID initiator) {

    this.setId(String.valueOf(key));
    this.setName(EVENT_NAME);
    this.setCategory(Category.EVENT);
    this.setVersion(EVENT_VERSION);
    this.setOccurredAt(OffsetDateTime.now());
    this.setPayload(lde);
    this.setMeta(new Meta(initiator.toString()));
  }

  @JsonProperty("id")
  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @JsonProperty("name")
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @JsonProperty("category")
  public Category getCategory() {
    return this.category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  @JsonProperty("version")
  public Integer getVersion() {
    return this.version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  @JsonProperty("occurred_at")
  @JsonSerialize(using = OffsetDateTimeSerializer.class)
  public OffsetDateTime getOccurredAt() {
    return this.occurredAt;
  }

  public void setOccurredAt(OffsetDateTime occurredAt) {
    this.occurredAt = occurredAt;
  }

  @JsonProperty("meta")
  public Meta getMeta() {
    return this.meta;
  }

  public void setMeta(Meta meta) {
    this.meta = meta;
  }

  @JsonProperty("payload")
  public Lde getPayload() {
    return this.payload;
  }

  public void setPayload(Lde payload) {
    this.payload = payload;
  }

}