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

import java.io.Serializable;
/**
 * MutationSerializer
 */

public class MutationSerializer  implements Serializable {
  @SerializedName("reference")
  private String reference = null;

  @SerializedName("protein")
  private String protein = null;

  @SerializedName("mutation_pos")
  private Integer mutationPos = null;

  @SerializedName("mutation_from")
  private String mutationFrom = null;

  @SerializedName("mutation_to")
  private String mutationTo = null;

  @SerializedName("ligand_name")
  private String ligandName = null;

  @SerializedName("ligand_idtype")
  private String ligandIdtype = null;

  @SerializedName("ligand_id")
  private String ligandId = null;

  @SerializedName("ligand_class")
  private String ligandClass = null;

  @SerializedName("exp_type")
  private String expType = null;

  @SerializedName("exp_func")
  private String expFunc = null;

  @SerializedName("exp_wt_value")
  private Float expWtValue = null;

  @SerializedName("exp_wt_unit")
  private String expWtUnit = null;

  @SerializedName("exp_mu_effect_sign")
  private String expMuEffectSign = null;

  @SerializedName("exp_mu_effect_type")
  private String expMuEffectType = null;

  @SerializedName("exp_mu_effect_value")
  private Float expMuEffectValue = null;

  @SerializedName("exp_fold_change")
  private Float expFoldChange = null;

  @SerializedName("exp_mu_effect_qual")
  private String expMuEffectQual = null;

  @SerializedName("exp_mu_effect_ligand_prop")
  private String expMuEffectLigandProp = null;

  @SerializedName("exp_mu_ligand_ref")
  private String expMuLigandRef = null;

  @SerializedName("opt_type")
  private String optType = null;

  @SerializedName("opt_wt")
  private Float optWt = null;

  @SerializedName("opt_mu")
  private Float optMu = null;

  @SerializedName("opt_sign")
  private String optSign = null;

  @SerializedName("opt_percentage")
  private Float optPercentage = null;

  @SerializedName("opt_qual")
  private String optQual = null;

  @SerializedName("opt_agonist")
  private String optAgonist = null;

  public MutationSerializer reference(String reference) {
    this.reference = reference;
    return this;
  }

   /**
   * Get reference
   * @return reference
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public MutationSerializer protein(String protein) {
    this.protein = protein;
    return this;
  }

   /**
   * Get protein
   * @return protein
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public String getProtein() {
    return protein;
  }

  public void setProtein(String protein) {
    this.protein = protein;
  }

  public MutationSerializer mutationPos(Integer mutationPos) {
    this.mutationPos = mutationPos;
    return this;
  }

   /**
   * Get mutationPos
   * @return mutationPos
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public Integer getMutationPos() {
    return mutationPos;
  }

  public void setMutationPos(Integer mutationPos) {
    this.mutationPos = mutationPos;
  }

  public MutationSerializer mutationFrom(String mutationFrom) {
    this.mutationFrom = mutationFrom;
    return this;
  }

   /**
   * Get mutationFrom
   * @return mutationFrom
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public String getMutationFrom() {
    return mutationFrom;
  }

  public void setMutationFrom(String mutationFrom) {
    this.mutationFrom = mutationFrom;
  }

  public MutationSerializer mutationTo(String mutationTo) {
    this.mutationTo = mutationTo;
    return this;
  }

   /**
   * Get mutationTo
   * @return mutationTo
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public String getMutationTo() {
    return mutationTo;
  }

  public void setMutationTo(String mutationTo) {
    this.mutationTo = mutationTo;
  }

  public MutationSerializer ligandName(String ligandName) {
    this.ligandName = ligandName;
    return this;
  }

   /**
   * Get ligandName
   * @return ligandName
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public String getLigandName() {
    return ligandName;
  }

  public void setLigandName(String ligandName) {
    this.ligandName = ligandName;
  }

  public MutationSerializer ligandIdtype(String ligandIdtype) {
    this.ligandIdtype = ligandIdtype;
    return this;
  }

   /**
   * Get ligandIdtype
   * @return ligandIdtype
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public String getLigandIdtype() {
    return ligandIdtype;
  }

  public void setLigandIdtype(String ligandIdtype) {
    this.ligandIdtype = ligandIdtype;
  }

  public MutationSerializer ligandId(String ligandId) {
    this.ligandId = ligandId;
    return this;
  }

   /**
   * Get ligandId
   * @return ligandId
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public String getLigandId() {
    return ligandId;
  }

  public void setLigandId(String ligandId) {
    this.ligandId = ligandId;
  }

  public MutationSerializer ligandClass(String ligandClass) {
    this.ligandClass = ligandClass;
    return this;
  }

   /**
   * Get ligandClass
   * @return ligandClass
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public String getLigandClass() {
    return ligandClass;
  }

  public void setLigandClass(String ligandClass) {
    this.ligandClass = ligandClass;
  }

  public MutationSerializer expType(String expType) {
    this.expType = expType;
    return this;
  }

   /**
   * Get expType
   * @return expType
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public String getExpType() {
    return expType;
  }

  public void setExpType(String expType) {
    this.expType = expType;
  }

  public MutationSerializer expFunc(String expFunc) {
    this.expFunc = expFunc;
    return this;
  }

   /**
   * Get expFunc
   * @return expFunc
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public String getExpFunc() {
    return expFunc;
  }

  public void setExpFunc(String expFunc) {
    this.expFunc = expFunc;
  }

  public MutationSerializer expWtValue(Float expWtValue) {
    this.expWtValue = expWtValue;
    return this;
  }

   /**
   * Get expWtValue
   * @return expWtValue
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public Float getExpWtValue() {
    return expWtValue;
  }

  public void setExpWtValue(Float expWtValue) {
    this.expWtValue = expWtValue;
  }

  public MutationSerializer expWtUnit(String expWtUnit) {
    this.expWtUnit = expWtUnit;
    return this;
  }

   /**
   * Get expWtUnit
   * @return expWtUnit
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public String getExpWtUnit() {
    return expWtUnit;
  }

  public void setExpWtUnit(String expWtUnit) {
    this.expWtUnit = expWtUnit;
  }

  public MutationSerializer expMuEffectSign(String expMuEffectSign) {
    this.expMuEffectSign = expMuEffectSign;
    return this;
  }

   /**
   * Get expMuEffectSign
   * @return expMuEffectSign
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public String getExpMuEffectSign() {
    return expMuEffectSign;
  }

  public void setExpMuEffectSign(String expMuEffectSign) {
    this.expMuEffectSign = expMuEffectSign;
  }

  public MutationSerializer expMuEffectType(String expMuEffectType) {
    this.expMuEffectType = expMuEffectType;
    return this;
  }

   /**
   * Get expMuEffectType
   * @return expMuEffectType
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public String getExpMuEffectType() {
    return expMuEffectType;
  }

  public void setExpMuEffectType(String expMuEffectType) {
    this.expMuEffectType = expMuEffectType;
  }

  public MutationSerializer expMuEffectValue(Float expMuEffectValue) {
    this.expMuEffectValue = expMuEffectValue;
    return this;
  }

   /**
   * Get expMuEffectValue
   * @return expMuEffectValue
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public Float getExpMuEffectValue() {
    return expMuEffectValue;
  }

  public void setExpMuEffectValue(Float expMuEffectValue) {
    this.expMuEffectValue = expMuEffectValue;
  }

  public MutationSerializer expFoldChange(Float expFoldChange) {
    this.expFoldChange = expFoldChange;
    return this;
  }

   /**
   * Get expFoldChange
   * @return expFoldChange
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public Float getExpFoldChange() {
    return expFoldChange;
  }

  public void setExpFoldChange(Float expFoldChange) {
    this.expFoldChange = expFoldChange;
  }

  public MutationSerializer expMuEffectQual(String expMuEffectQual) {
    this.expMuEffectQual = expMuEffectQual;
    return this;
  }

   /**
   * Get expMuEffectQual
   * @return expMuEffectQual
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public String getExpMuEffectQual() {
    return expMuEffectQual;
  }

  public void setExpMuEffectQual(String expMuEffectQual) {
    this.expMuEffectQual = expMuEffectQual;
  }

  public MutationSerializer expMuEffectLigandProp(String expMuEffectLigandProp) {
    this.expMuEffectLigandProp = expMuEffectLigandProp;
    return this;
  }

   /**
   * Get expMuEffectLigandProp
   * @return expMuEffectLigandProp
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public String getExpMuEffectLigandProp() {
    return expMuEffectLigandProp;
  }

  public void setExpMuEffectLigandProp(String expMuEffectLigandProp) {
    this.expMuEffectLigandProp = expMuEffectLigandProp;
  }

  public MutationSerializer expMuLigandRef(String expMuLigandRef) {
    this.expMuLigandRef = expMuLigandRef;
    return this;
  }

   /**
   * Get expMuLigandRef
   * @return expMuLigandRef
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public String getExpMuLigandRef() {
    return expMuLigandRef;
  }

  public void setExpMuLigandRef(String expMuLigandRef) {
    this.expMuLigandRef = expMuLigandRef;
  }

  public MutationSerializer optType(String optType) {
    this.optType = optType;
    return this;
  }

   /**
   * Get optType
   * @return optType
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public String getOptType() {
    return optType;
  }

  public void setOptType(String optType) {
    this.optType = optType;
  }

  public MutationSerializer optWt(Float optWt) {
    this.optWt = optWt;
    return this;
  }

   /**
   * Get optWt
   * @return optWt
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public Float getOptWt() {
    return optWt;
  }

  public void setOptWt(Float optWt) {
    this.optWt = optWt;
  }

  public MutationSerializer optMu(Float optMu) {
    this.optMu = optMu;
    return this;
  }

   /**
   * Get optMu
   * @return optMu
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public Float getOptMu() {
    return optMu;
  }

  public void setOptMu(Float optMu) {
    this.optMu = optMu;
  }

  public MutationSerializer optSign(String optSign) {
    this.optSign = optSign;
    return this;
  }

   /**
   * Get optSign
   * @return optSign
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public String getOptSign() {
    return optSign;
  }

  public void setOptSign(String optSign) {
    this.optSign = optSign;
  }

  public MutationSerializer optPercentage(Float optPercentage) {
    this.optPercentage = optPercentage;
    return this;
  }

   /**
   * Get optPercentage
   * @return optPercentage
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public Float getOptPercentage() {
    return optPercentage;
  }

  public void setOptPercentage(Float optPercentage) {
    this.optPercentage = optPercentage;
  }

  public MutationSerializer optQual(String optQual) {
    this.optQual = optQual;
    return this;
  }

   /**
   * Get optQual
   * @return optQual
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public String getOptQual() {
    return optQual;
  }

  public void setOptQual(String optQual) {
    this.optQual = optQual;
  }

  public MutationSerializer optAgonist(String optAgonist) {
    this.optAgonist = optAgonist;
    return this;
  }

   /**
   * Get optAgonist
   * @return optAgonist
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public String getOptAgonist() {
    return optAgonist;
  }

  public void setOptAgonist(String optAgonist) {
    this.optAgonist = optAgonist;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MutationSerializer mutationSerializer = (MutationSerializer) o;
    return Objects.equals(this.reference, mutationSerializer.reference) &&
        Objects.equals(this.protein, mutationSerializer.protein) &&
        Objects.equals(this.mutationPos, mutationSerializer.mutationPos) &&
        Objects.equals(this.mutationFrom, mutationSerializer.mutationFrom) &&
        Objects.equals(this.mutationTo, mutationSerializer.mutationTo) &&
        Objects.equals(this.ligandName, mutationSerializer.ligandName) &&
        Objects.equals(this.ligandIdtype, mutationSerializer.ligandIdtype) &&
        Objects.equals(this.ligandId, mutationSerializer.ligandId) &&
        Objects.equals(this.ligandClass, mutationSerializer.ligandClass) &&
        Objects.equals(this.expType, mutationSerializer.expType) &&
        Objects.equals(this.expFunc, mutationSerializer.expFunc) &&
        Objects.equals(this.expWtValue, mutationSerializer.expWtValue) &&
        Objects.equals(this.expWtUnit, mutationSerializer.expWtUnit) &&
        Objects.equals(this.expMuEffectSign, mutationSerializer.expMuEffectSign) &&
        Objects.equals(this.expMuEffectType, mutationSerializer.expMuEffectType) &&
        Objects.equals(this.expMuEffectValue, mutationSerializer.expMuEffectValue) &&
        Objects.equals(this.expFoldChange, mutationSerializer.expFoldChange) &&
        Objects.equals(this.expMuEffectQual, mutationSerializer.expMuEffectQual) &&
        Objects.equals(this.expMuEffectLigandProp, mutationSerializer.expMuEffectLigandProp) &&
        Objects.equals(this.expMuLigandRef, mutationSerializer.expMuLigandRef) &&
        Objects.equals(this.optType, mutationSerializer.optType) &&
        Objects.equals(this.optWt, mutationSerializer.optWt) &&
        Objects.equals(this.optMu, mutationSerializer.optMu) &&
        Objects.equals(this.optSign, mutationSerializer.optSign) &&
        Objects.equals(this.optPercentage, mutationSerializer.optPercentage) &&
        Objects.equals(this.optQual, mutationSerializer.optQual) &&
        Objects.equals(this.optAgonist, mutationSerializer.optAgonist);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reference, protein, mutationPos, mutationFrom, mutationTo, ligandName, ligandIdtype, ligandId, ligandClass, expType, expFunc, expWtValue, expWtUnit, expMuEffectSign, expMuEffectType, expMuEffectValue, expFoldChange, expMuEffectQual, expMuEffectLigandProp, expMuLigandRef, optType, optWt, optMu, optSign, optPercentage, optQual, optAgonist);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MutationSerializer {\n");
    
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    protein: ").append(toIndentedString(protein)).append("\n");
    sb.append("    mutationPos: ").append(toIndentedString(mutationPos)).append("\n");
    sb.append("    mutationFrom: ").append(toIndentedString(mutationFrom)).append("\n");
    sb.append("    mutationTo: ").append(toIndentedString(mutationTo)).append("\n");
    sb.append("    ligandName: ").append(toIndentedString(ligandName)).append("\n");
    sb.append("    ligandIdtype: ").append(toIndentedString(ligandIdtype)).append("\n");
    sb.append("    ligandId: ").append(toIndentedString(ligandId)).append("\n");
    sb.append("    ligandClass: ").append(toIndentedString(ligandClass)).append("\n");
    sb.append("    expType: ").append(toIndentedString(expType)).append("\n");
    sb.append("    expFunc: ").append(toIndentedString(expFunc)).append("\n");
    sb.append("    expWtValue: ").append(toIndentedString(expWtValue)).append("\n");
    sb.append("    expWtUnit: ").append(toIndentedString(expWtUnit)).append("\n");
    sb.append("    expMuEffectSign: ").append(toIndentedString(expMuEffectSign)).append("\n");
    sb.append("    expMuEffectType: ").append(toIndentedString(expMuEffectType)).append("\n");
    sb.append("    expMuEffectValue: ").append(toIndentedString(expMuEffectValue)).append("\n");
    sb.append("    expFoldChange: ").append(toIndentedString(expFoldChange)).append("\n");
    sb.append("    expMuEffectQual: ").append(toIndentedString(expMuEffectQual)).append("\n");
    sb.append("    expMuEffectLigandProp: ").append(toIndentedString(expMuEffectLigandProp)).append("\n");
    sb.append("    expMuLigandRef: ").append(toIndentedString(expMuLigandRef)).append("\n");
    sb.append("    optType: ").append(toIndentedString(optType)).append("\n");
    sb.append("    optWt: ").append(toIndentedString(optWt)).append("\n");
    sb.append("    optMu: ").append(toIndentedString(optMu)).append("\n");
    sb.append("    optSign: ").append(toIndentedString(optSign)).append("\n");
    sb.append("    optPercentage: ").append(toIndentedString(optPercentage)).append("\n");
    sb.append("    optQual: ").append(toIndentedString(optQual)).append("\n");
    sb.append("    optAgonist: ").append(toIndentedString(optAgonist)).append("\n");
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

