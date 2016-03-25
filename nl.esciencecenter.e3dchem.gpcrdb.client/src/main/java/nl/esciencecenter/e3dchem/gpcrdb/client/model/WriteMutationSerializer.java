package nl.esciencecenter.e3dchem.gpcrdb.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-03-25T11:18:53.274+01:00")
public class WriteMutationSerializer   {
  
  private String reference = null;
  private String protein = null;
  private Long mutationPos = null;
  private String mutationFrom = null;
  private String mutationTo = null;
  private String ligandName = null;
  private String ligandIdtype = null;
  private String ligandId = null;
  private String ligandClass = null;
  private String expType = null;
  private String expFunc = null;
  private Float expWtValue = null;
  private String expWtUnit = null;
  private String expMuEffectSign = null;
  private String expMuEffectType = null;
  private Float expMuEffectValue = null;
  private String expMuEffectQual = null;
  private String expMuEffectLigandProp = null;
  private String expMuLigandRef = null;
  private String optType = null;
  private Float optWt = null;
  private Float optMu = null;
  private String optSign = null;
  private Float optPercentage = null;
  private String optQual = null;
  private String optAgonist = null;
  private Date addedDate = null;

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("reference")
  public String getReference() {
    return reference;
  }
  public void setReference(String reference) {
    this.reference = reference;
  }

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("protein")
  public String getProtein() {
    return protein;
  }
  public void setProtein(String protein) {
    this.protein = protein;
  }

  
  /**
   * minimum: -32768.0
   * maximum: 32767.0
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("mutation_pos")
  public Long getMutationPos() {
    return mutationPos;
  }
  public void setMutationPos(Long mutationPos) {
    this.mutationPos = mutationPos;
  }

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("mutation_from")
  public String getMutationFrom() {
    return mutationFrom;
  }
  public void setMutationFrom(String mutationFrom) {
    this.mutationFrom = mutationFrom;
  }

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("mutation_to")
  public String getMutationTo() {
    return mutationTo;
  }
  public void setMutationTo(String mutationTo) {
    this.mutationTo = mutationTo;
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
  @JsonProperty("ligand_idtype")
  public String getLigandIdtype() {
    return ligandIdtype;
  }
  public void setLigandIdtype(String ligandIdtype) {
    this.ligandIdtype = ligandIdtype;
  }

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("ligand_id")
  public String getLigandId() {
    return ligandId;
  }
  public void setLigandId(String ligandId) {
    this.ligandId = ligandId;
  }

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("ligand_class")
  public String getLigandClass() {
    return ligandClass;
  }
  public void setLigandClass(String ligandClass) {
    this.ligandClass = ligandClass;
  }

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("exp_type")
  public String getExpType() {
    return expType;
  }
  public void setExpType(String expType) {
    this.expType = expType;
  }

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("exp_func")
  public String getExpFunc() {
    return expFunc;
  }
  public void setExpFunc(String expFunc) {
    this.expFunc = expFunc;
  }

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("exp_wt_value")
  public Float getExpWtValue() {
    return expWtValue;
  }
  public void setExpWtValue(Float expWtValue) {
    this.expWtValue = expWtValue;
  }

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("exp_wt_unit")
  public String getExpWtUnit() {
    return expWtUnit;
  }
  public void setExpWtUnit(String expWtUnit) {
    this.expWtUnit = expWtUnit;
  }

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("exp_mu_effect_sign")
  public String getExpMuEffectSign() {
    return expMuEffectSign;
  }
  public void setExpMuEffectSign(String expMuEffectSign) {
    this.expMuEffectSign = expMuEffectSign;
  }

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("exp_mu_effect_type")
  public String getExpMuEffectType() {
    return expMuEffectType;
  }
  public void setExpMuEffectType(String expMuEffectType) {
    this.expMuEffectType = expMuEffectType;
  }

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("exp_mu_effect_value")
  public Float getExpMuEffectValue() {
    return expMuEffectValue;
  }
  public void setExpMuEffectValue(Float expMuEffectValue) {
    this.expMuEffectValue = expMuEffectValue;
  }

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("exp_mu_effect_qual")
  public String getExpMuEffectQual() {
    return expMuEffectQual;
  }
  public void setExpMuEffectQual(String expMuEffectQual) {
    this.expMuEffectQual = expMuEffectQual;
  }

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("exp_mu_effect_ligand_prop")
  public String getExpMuEffectLigandProp() {
    return expMuEffectLigandProp;
  }
  public void setExpMuEffectLigandProp(String expMuEffectLigandProp) {
    this.expMuEffectLigandProp = expMuEffectLigandProp;
  }

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("exp_mu_ligand_ref")
  public String getExpMuLigandRef() {
    return expMuLigandRef;
  }
  public void setExpMuLigandRef(String expMuLigandRef) {
    this.expMuLigandRef = expMuLigandRef;
  }

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("opt_type")
  public String getOptType() {
    return optType;
  }
  public void setOptType(String optType) {
    this.optType = optType;
  }

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("opt_wt")
  public Float getOptWt() {
    return optWt;
  }
  public void setOptWt(Float optWt) {
    this.optWt = optWt;
  }

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("opt_mu")
  public Float getOptMu() {
    return optMu;
  }
  public void setOptMu(Float optMu) {
    this.optMu = optMu;
  }

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("opt_sign")
  public String getOptSign() {
    return optSign;
  }
  public void setOptSign(String optSign) {
    this.optSign = optSign;
  }

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("opt_percentage")
  public Float getOptPercentage() {
    return optPercentage;
  }
  public void setOptPercentage(Float optPercentage) {
    this.optPercentage = optPercentage;
  }

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("opt_qual")
  public String getOptQual() {
    return optQual;
  }
  public void setOptQual(String optQual) {
    this.optQual = optQual;
  }

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("opt_agonist")
  public String getOptAgonist() {
    return optAgonist;
  }
  public void setOptAgonist(String optAgonist) {
    this.optAgonist = optAgonist;
  }

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("added_date")
  public Date getAddedDate() {
    return addedDate;
  }
  public void setAddedDate(Date addedDate) {
    this.addedDate = addedDate;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WriteMutationSerializer writeMutationSerializer = (WriteMutationSerializer) o;
    return Objects.equals(reference, writeMutationSerializer.reference) &&
        Objects.equals(protein, writeMutationSerializer.protein) &&
        Objects.equals(mutationPos, writeMutationSerializer.mutationPos) &&
        Objects.equals(mutationFrom, writeMutationSerializer.mutationFrom) &&
        Objects.equals(mutationTo, writeMutationSerializer.mutationTo) &&
        Objects.equals(ligandName, writeMutationSerializer.ligandName) &&
        Objects.equals(ligandIdtype, writeMutationSerializer.ligandIdtype) &&
        Objects.equals(ligandId, writeMutationSerializer.ligandId) &&
        Objects.equals(ligandClass, writeMutationSerializer.ligandClass) &&
        Objects.equals(expType, writeMutationSerializer.expType) &&
        Objects.equals(expFunc, writeMutationSerializer.expFunc) &&
        Objects.equals(expWtValue, writeMutationSerializer.expWtValue) &&
        Objects.equals(expWtUnit, writeMutationSerializer.expWtUnit) &&
        Objects.equals(expMuEffectSign, writeMutationSerializer.expMuEffectSign) &&
        Objects.equals(expMuEffectType, writeMutationSerializer.expMuEffectType) &&
        Objects.equals(expMuEffectValue, writeMutationSerializer.expMuEffectValue) &&
        Objects.equals(expMuEffectQual, writeMutationSerializer.expMuEffectQual) &&
        Objects.equals(expMuEffectLigandProp, writeMutationSerializer.expMuEffectLigandProp) &&
        Objects.equals(expMuLigandRef, writeMutationSerializer.expMuLigandRef) &&
        Objects.equals(optType, writeMutationSerializer.optType) &&
        Objects.equals(optWt, writeMutationSerializer.optWt) &&
        Objects.equals(optMu, writeMutationSerializer.optMu) &&
        Objects.equals(optSign, writeMutationSerializer.optSign) &&
        Objects.equals(optPercentage, writeMutationSerializer.optPercentage) &&
        Objects.equals(optQual, writeMutationSerializer.optQual) &&
        Objects.equals(optAgonist, writeMutationSerializer.optAgonist) &&
        Objects.equals(addedDate, writeMutationSerializer.addedDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reference, protein, mutationPos, mutationFrom, mutationTo, ligandName, ligandIdtype, ligandId, ligandClass, expType, expFunc, expWtValue, expWtUnit, expMuEffectSign, expMuEffectType, expMuEffectValue, expMuEffectQual, expMuEffectLigandProp, expMuLigandRef, optType, optWt, optMu, optSign, optPercentage, optQual, optAgonist, addedDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WriteMutationSerializer {\n");
    
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
    sb.append("    addedDate: ").append(toIndentedString(addedDate)).append("\n");
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

