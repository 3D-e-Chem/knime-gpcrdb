package nl.esciencecenter.e3dchem.gpcrdb.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-03-25T11:18:53.274+01:00")
public class ProteinSerializer   {
  
  private String entryName = null;
  private String name = null;
  private String accession = null;
  private String family = null;
  private String species = null;
  private String source = null;
  private String residueNumberingScheme = null;
  private String sequence = null;

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("entry_name")
  public String getEntryName() {
    return entryName;
  }
  public void setEntryName(String entryName) {
    this.entryName = entryName;
  }

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("accession")
  public String getAccession() {
    return accession;
  }
  public void setAccession(String accession) {
    this.accession = accession;
  }

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("family")
  public String getFamily() {
    return family;
  }
  public void setFamily(String family) {
    this.family = family;
  }

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("species")
  public String getSpecies() {
    return species;
  }
  public void setSpecies(String species) {
    this.species = species;
  }

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("source")
  public String getSource() {
    return source;
  }
  public void setSource(String source) {
    this.source = source;
  }

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("residue_numbering_scheme")
  public String getResidueNumberingScheme() {
    return residueNumberingScheme;
  }
  public void setResidueNumberingScheme(String residueNumberingScheme) {
    this.residueNumberingScheme = residueNumberingScheme;
  }

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("sequence")
  public String getSequence() {
    return sequence;
  }
  public void setSequence(String sequence) {
    this.sequence = sequence;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProteinSerializer proteinSerializer = (ProteinSerializer) o;
    return Objects.equals(entryName, proteinSerializer.entryName) &&
        Objects.equals(name, proteinSerializer.name) &&
        Objects.equals(accession, proteinSerializer.accession) &&
        Objects.equals(family, proteinSerializer.family) &&
        Objects.equals(species, proteinSerializer.species) &&
        Objects.equals(source, proteinSerializer.source) &&
        Objects.equals(residueNumberingScheme, proteinSerializer.residueNumberingScheme) &&
        Objects.equals(sequence, proteinSerializer.sequence);
  }

  @Override
  public int hashCode() {
    return Objects.hash(entryName, name, accession, family, species, source, residueNumberingScheme, sequence);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProteinSerializer {\n");
    
    sb.append("    entryName: ").append(toIndentedString(entryName)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    accession: ").append(toIndentedString(accession)).append("\n");
    sb.append("    family: ").append(toIndentedString(family)).append("\n");
    sb.append("    species: ").append(toIndentedString(species)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    residueNumberingScheme: ").append(toIndentedString(residueNumberingScheme)).append("\n");
    sb.append("    sequence: ").append(toIndentedString(sequence)).append("\n");
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

