/**
 * 
 * No descripton provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package nl.esciencecenter.e3dchem.gpcrdb.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import nl.esciencecenter.e3dchem.gpcrdb.client.model.ResidueGenericNumberSerializer;

import java.io.Serializable;
/**
 * ResidueExtendedSerializer
 */

public class ResidueExtendedSerializer  implements Serializable {
  @SerializedName("sequence_number")
  private Integer sequenceNumber = null;

  @SerializedName("amino_acid")
  private String aminoAcid = null;

  @SerializedName("protein_segment")
  private String proteinSegment = null;

  @SerializedName("display_generic_number")
  private String displayGenericNumber = null;

  @SerializedName("alternative_generic_numbers")
  private List<ResidueGenericNumberSerializer> alternativeGenericNumbers = new ArrayList<ResidueGenericNumberSerializer>();

  public ResidueExtendedSerializer sequenceNumber(Integer sequenceNumber) {
    this.sequenceNumber = sequenceNumber;
    return this;
  }

   /**
   * Get sequenceNumber
   * @return sequenceNumber
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public Integer getSequenceNumber() {
    return sequenceNumber;
  }

  public void setSequenceNumber(Integer sequenceNumber) {
    this.sequenceNumber = sequenceNumber;
  }

  public ResidueExtendedSerializer aminoAcid(String aminoAcid) {
    this.aminoAcid = aminoAcid;
    return this;
  }

   /**
   * Get aminoAcid
   * @return aminoAcid
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public String getAminoAcid() {
    return aminoAcid;
  }

  public void setAminoAcid(String aminoAcid) {
    this.aminoAcid = aminoAcid;
  }

  public ResidueExtendedSerializer proteinSegment(String proteinSegment) {
    this.proteinSegment = proteinSegment;
    return this;
  }

   /**
   * Get proteinSegment
   * @return proteinSegment
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public String getProteinSegment() {
    return proteinSegment;
  }

  public void setProteinSegment(String proteinSegment) {
    this.proteinSegment = proteinSegment;
  }

  public ResidueExtendedSerializer displayGenericNumber(String displayGenericNumber) {
    this.displayGenericNumber = displayGenericNumber;
    return this;
  }

   /**
   * Get displayGenericNumber
   * @return displayGenericNumber
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public String getDisplayGenericNumber() {
    return displayGenericNumber;
  }

  public void setDisplayGenericNumber(String displayGenericNumber) {
    this.displayGenericNumber = displayGenericNumber;
  }

  public ResidueExtendedSerializer alternativeGenericNumbers(List<ResidueGenericNumberSerializer> alternativeGenericNumbers) {
    this.alternativeGenericNumbers = alternativeGenericNumbers;
    return this;
  }

  public ResidueExtendedSerializer addAlternativeGenericNumbersItem(ResidueGenericNumberSerializer alternativeGenericNumbersItem) {
    this.alternativeGenericNumbers.add(alternativeGenericNumbersItem);
    return this;
  }

   /**
   * Get alternativeGenericNumbers
   * @return alternativeGenericNumbers
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public List<ResidueGenericNumberSerializer> getAlternativeGenericNumbers() {
    return alternativeGenericNumbers;
  }

  public void setAlternativeGenericNumbers(List<ResidueGenericNumberSerializer> alternativeGenericNumbers) {
    this.alternativeGenericNumbers = alternativeGenericNumbers;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResidueExtendedSerializer residueExtendedSerializer = (ResidueExtendedSerializer) o;
    return Objects.equals(this.sequenceNumber, residueExtendedSerializer.sequenceNumber) &&
        Objects.equals(this.aminoAcid, residueExtendedSerializer.aminoAcid) &&
        Objects.equals(this.proteinSegment, residueExtendedSerializer.proteinSegment) &&
        Objects.equals(this.displayGenericNumber, residueExtendedSerializer.displayGenericNumber) &&
        Objects.equals(this.alternativeGenericNumbers, residueExtendedSerializer.alternativeGenericNumbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sequenceNumber, aminoAcid, proteinSegment, displayGenericNumber, alternativeGenericNumbers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResidueExtendedSerializer {\n");
    
    sb.append("    sequenceNumber: ").append(toIndentedString(sequenceNumber)).append("\n");
    sb.append("    aminoAcid: ").append(toIndentedString(aminoAcid)).append("\n");
    sb.append("    proteinSegment: ").append(toIndentedString(proteinSegment)).append("\n");
    sb.append("    displayGenericNumber: ").append(toIndentedString(displayGenericNumber)).append("\n");
    sb.append("    alternativeGenericNumbers: ").append(toIndentedString(alternativeGenericNumbers)).append("\n");
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

