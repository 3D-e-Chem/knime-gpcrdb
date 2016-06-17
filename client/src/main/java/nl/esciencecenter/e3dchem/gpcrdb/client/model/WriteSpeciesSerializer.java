package nl.esciencecenter.e3dchem.gpcrdb.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-03-25T11:18:53.274+01:00")
public class WriteSpeciesSerializer   {
  
  private String latinName = null;
  private String commonName = null;

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("latin_name")
  public String getLatinName() {
    return latinName;
  }
  public void setLatinName(String latinName) {
    this.latinName = latinName;
  }

  
  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("common_name")
  public String getCommonName() {
    return commonName;
  }
  public void setCommonName(String commonName) {
    this.commonName = commonName;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WriteSpeciesSerializer writeSpeciesSerializer = (WriteSpeciesSerializer) o;
    return Objects.equals(latinName, writeSpeciesSerializer.latinName) &&
        Objects.equals(commonName, writeSpeciesSerializer.commonName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(latinName, commonName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WriteSpeciesSerializer {\n");
    
    sb.append("    latinName: ").append(toIndentedString(latinName)).append("\n");
    sb.append("    commonName: ").append(toIndentedString(commonName)).append("\n");
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
