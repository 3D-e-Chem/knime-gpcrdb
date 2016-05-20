package nl.esciencecenter.e3dchem.gpcrdb.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-03-25T11:18:53.274+01:00")
public class StructureLigandInteractionSerializer   {
  
  private String pdbCode = null;
  private String ligandName = null;
  private String aminoAcid = null;
  private Long sequenceNumber = null;
  private String displayGenericNumber = null;
  private String interactionType = null;

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("pdb_code")
  public String getPdbCode() {
    return pdbCode;
  }
  public void setPdbCode(String pdbCode) {
    this.pdbCode = pdbCode;
  }

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("ligand_name")
  public String getLigandName() {
    return ligandName;
  }
  public void setLigandName(String ligandName) {
    this.ligandName = ligandName;
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
  @JsonProperty("display_generic_number")
  public String getDisplayGenericNumber() {
    return displayGenericNumber;
  }
  public void setDisplayGenericNumber(String displayGenericNumber) {
    this.displayGenericNumber = displayGenericNumber;
  }

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("interaction_type")
  public String getInteractionType() {
    return interactionType;
  }
  public void setInteractionType(String interactionType) {
    this.interactionType = interactionType;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StructureLigandInteractionSerializer structureLigandInteractionSerializer = (StructureLigandInteractionSerializer) o;
    return Objects.equals(pdbCode, structureLigandInteractionSerializer.pdbCode) &&
        Objects.equals(ligandName, structureLigandInteractionSerializer.ligandName) &&
        Objects.equals(aminoAcid, structureLigandInteractionSerializer.aminoAcid) &&
        Objects.equals(sequenceNumber, structureLigandInteractionSerializer.sequenceNumber) &&
        Objects.equals(displayGenericNumber, structureLigandInteractionSerializer.displayGenericNumber) &&
        Objects.equals(interactionType, structureLigandInteractionSerializer.interactionType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pdbCode, ligandName, aminoAcid, sequenceNumber, displayGenericNumber, interactionType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StructureLigandInteractionSerializer {\n");
    
    sb.append("    pdbCode: ").append(toIndentedString(pdbCode)).append("\n");
    sb.append("    ligandName: ").append(toIndentedString(ligandName)).append("\n");
    sb.append("    aminoAcid: ").append(toIndentedString(aminoAcid)).append("\n");
    sb.append("    sequenceNumber: ").append(toIndentedString(sequenceNumber)).append("\n");
    sb.append("    displayGenericNumber: ").append(toIndentedString(displayGenericNumber)).append("\n");
    sb.append("    interactionType: ").append(toIndentedString(interactionType)).append("\n");
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

