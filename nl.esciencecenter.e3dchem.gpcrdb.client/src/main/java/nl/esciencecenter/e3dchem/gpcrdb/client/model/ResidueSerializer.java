package nl.esciencecenter.e3dchem.gpcrdb.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-03-25T11:18:53.274+01:00")
public class ResidueSerializer   {
  
  private Long sequenceNumber = null;
  private String aminoAcid = null;
  private String proteinSegment = null;
  private String displayGenericNumber = null;

  
  /**
   * minimum: -32768.0
   * maximum: 32767.0
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("sequence_number")
  public Long getSequenceNumber() {
    return sequenceNumber;
  }
  public void setSequenceNumber(Long sequenceNumber) {
    this.sequenceNumber = sequenceNumber;
  }

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("amino_acid")
  public String getAminoAcid() {
    return aminoAcid;
  }
  public void setAminoAcid(String aminoAcid) {
    this.aminoAcid = aminoAcid;
  }

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("protein_segment")
  public String getProteinSegment() {
    return proteinSegment;
  }
  public void setProteinSegment(String proteinSegment) {
    this.proteinSegment = proteinSegment;
  }

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("display_generic_number")
  public String getDisplayGenericNumber() {
    return displayGenericNumber;
  }
  public void setDisplayGenericNumber(String displayGenericNumber) {
    this.displayGenericNumber = displayGenericNumber;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResidueSerializer residueSerializer = (ResidueSerializer) o;
    return Objects.equals(sequenceNumber, residueSerializer.sequenceNumber) &&
        Objects.equals(aminoAcid, residueSerializer.aminoAcid) &&
        Objects.equals(proteinSegment, residueSerializer.proteinSegment) &&
        Objects.equals(displayGenericNumber, residueSerializer.displayGenericNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sequenceNumber, aminoAcid, proteinSegment, displayGenericNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResidueSerializer {\n");
    
    sb.append("    sequenceNumber: ").append(toIndentedString(sequenceNumber)).append("\n");
    sb.append("    aminoAcid: ").append(toIndentedString(aminoAcid)).append("\n");
    sb.append("    proteinSegment: ").append(toIndentedString(proteinSegment)).append("\n");
    sb.append("    displayGenericNumber: ").append(toIndentedString(displayGenericNumber)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

