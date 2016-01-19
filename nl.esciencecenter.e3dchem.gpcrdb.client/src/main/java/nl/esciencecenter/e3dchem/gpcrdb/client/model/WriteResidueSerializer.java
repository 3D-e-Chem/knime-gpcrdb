package nl.esciencecenter.e3dchem.gpcrdb.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-01-19T13:05:55.822+01:00")
public class WriteResidueSerializer   {
  
  private Integer sequenceNumber = null;
  private String aminoAcid = null;

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("sequence_number")
  public Integer getSequenceNumber() {
    return sequenceNumber;
  }
  public void setSequenceNumber(Integer sequenceNumber) {
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

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WriteResidueSerializer writeResidueSerializer = (WriteResidueSerializer) o;
    return Objects.equals(sequenceNumber, writeResidueSerializer.sequenceNumber) &&
        Objects.equals(aminoAcid, writeResidueSerializer.aminoAcid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sequenceNumber, aminoAcid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WriteResidueSerializer {\n");
    
    sb.append("    sequenceNumber: ").append(toIndentedString(sequenceNumber)).append("\n");
    sb.append("    aminoAcid: ").append(toIndentedString(aminoAcid)).append("\n");
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

