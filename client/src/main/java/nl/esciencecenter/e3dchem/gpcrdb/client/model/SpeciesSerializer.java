/*
 * 
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package nl.esciencecenter.e3dchem.gpcrdb.client.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.io.Serializable;

/**
 * SpeciesSerializer
 */

public class SpeciesSerializer implements Serializable {
  private static final long serialVersionUID = 1L;

  @SerializedName("latin_name")
  private String latinName = null;

  @SerializedName("common_name")
  private String commonName = null;

  public SpeciesSerializer latinName(String latinName) {
    this.latinName = latinName;
    return this;
  }

   /**
   * Get latinName
   * @return latinName
  **/
  @ApiModelProperty(required = true, value = "")
  public String getLatinName() {
    return latinName;
  }

  public void setLatinName(String latinName) {
    this.latinName = latinName;
  }

  public SpeciesSerializer commonName(String commonName) {
    this.commonName = commonName;
    return this;
  }

   /**
   * Get commonName
   * @return commonName
  **/
  @ApiModelProperty(required = true, value = "")
  public String getCommonName() {
    return commonName;
  }

  public void setCommonName(String commonName) {
    this.commonName = commonName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpeciesSerializer speciesSerializer = (SpeciesSerializer) o;
    return Objects.equals(this.latinName, speciesSerializer.latinName) &&
        Objects.equals(this.commonName, speciesSerializer.commonName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(latinName, commonName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpeciesSerializer {\n");
    
    sb.append("    latinName: ").append(toIndentedString(latinName)).append("\n");
    sb.append("    commonName: ").append(toIndentedString(commonName)).append("\n");
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

