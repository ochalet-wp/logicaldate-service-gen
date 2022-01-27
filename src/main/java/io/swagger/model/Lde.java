package io.swagger.model;

import java.util.Map;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.threetenbp.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.threetenbp.ser.OffsetDateTimeSerializer;
import org.threeten.bp.LocalDate;
import org.threeten.bp.OffsetDateTime;

public class Lde {
  private LocalDate logicalDate;
  private OffsetDateTime creationDate;
  private String application;
  private String processingGroup;

  @JsonProperty("logical_date")
  @JsonSerialize(using = LocalDateSerializer.class)
  public LocalDate getLogicalDate() {
    return this.logicalDate;
  }

  public void setLogicalDate(LocalDate logicalDate) {
    this.logicalDate = logicalDate;
  }

  @JsonProperty("creation_date")
  @JsonSerialize(using = OffsetDateTimeSerializer.class)
  public OffsetDateTime getCreationDate() {
    return this.creationDate;
  }

  public void setCreationDate(OffsetDateTime creationDate) {
    this.creationDate = creationDate;
  }

  @JsonProperty("application")
  public String getApplication() {
    return this.application;
  }

  public void setApplication(String application) {
    this.application = application;
  }

  @JsonProperty("processing_group")
  public String getProcessingGroup() {
    return this.processingGroup;
  }

  public void setProcessingGroup(String processingGroup) {
    this.processingGroup = processingGroup;
  }

}