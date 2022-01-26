package io.swagger.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.threetenbp.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.threetenbp.ser.OffsetDateTimeSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
import org.threeten.bp.LocalDate;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Lde
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-01-25T14:45:15.330Z[GMT]")


public class Lde   {
  @JsonProperty("logical_date")
  private LocalDate logicalDate = null;

  @JsonProperty("creation_date")
  private OffsetDateTime creationDate = null;

  @JsonProperty("application")
  private String application = null;

  @JsonProperty("processing_group")
  private String processingGroup = null;

  public Lde logicalDate(LocalDate logicalDate) {
    this.logicalDate = logicalDate;
    return this;
  }

  /**
   * Get logicalDate
   * @return logicalDate
   **/
  @Schema(description = "")
  
    @Valid
    @JsonSerialize(using=LocalDateSerializer.class)
    public LocalDate getLogicalDate() {
    return logicalDate;
  }

  public void setLogicalDate(LocalDate logicalDate) {
    this.logicalDate = logicalDate;
  }

  public Lde creationDate(OffsetDateTime creationDate) {
    this.creationDate = creationDate;
    return this;
  }

  /**
   * Get creationDate
   * @return creationDate
   **/
  @Schema(description = "")
  
    @Valid
    @JsonSerialize(using=OffsetDateTimeSerializer.class)
    public OffsetDateTime getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(OffsetDateTime creationDate) {
    this.creationDate = creationDate;
  }

  public Lde application(String application) {
    this.application = application;
    return this;
  }

  /**
   * Get application
   * @return application
   **/
  @Schema(description = "")
  
    public String getApplication() {
    return application;
  }

  public void setApplication(String application) {
    this.application = application;
  }

  public Lde processingGroup(String processingGroup) {
    this.processingGroup = processingGroup;
    return this;
  }

  /**
   * Get processingGroup
   * @return processingGroup
   **/
  @Schema(description = "")
  
    public String getProcessingGroup() {
    return processingGroup;
  }

  public void setProcessingGroup(String processingGroup) {
    this.processingGroup = processingGroup;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Lde lde = (Lde) o;
    return Objects.equals(this.logicalDate, lde.logicalDate) &&
        Objects.equals(this.creationDate, lde.creationDate) &&
        Objects.equals(this.application, lde.application) &&
        Objects.equals(this.processingGroup, lde.processingGroup);
  }

  @Override
  public int hashCode() {
    return Objects.hash(logicalDate, creationDate, application, processingGroup);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Lde {\n");
    
    sb.append("    logicalDate: ").append(toIndentedString(logicalDate)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    application: ").append(toIndentedString(application)).append("\n");
    sb.append("    processingGroup: ").append(toIndentedString(processingGroup)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
