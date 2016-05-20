package nl.esciencecenter.e3dchem.gpcrdb.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-03-25T11:18:53.274+01:00")
public class ResidueGenericNumberSerializer   {
  
  private String scheme = null;
  private String label = null;

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("scheme")
  public String getScheme() {
    return scheme;
  }
  public void setScheme(String scheme) {
    this.scheme = scheme;
  }

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("label")
  public String getLabel() {
    return label;
  }
  public void setLabel(String label) {
    this.label = label;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResidueGenericNumberSerializer residueGenericNumberSerializer = (ResidueGenericNumberSerializer) o;
    return Objects.equals(scheme, residueGenericNumberSerializer.scheme) &&
        Objects.equals(label, residueGenericNumberSerializer.label);
  }

  @Override
  public int hashCode() {
    return Objects.hash(scheme, label);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResidueGenericNumberSerializer {\n");
    
    sb.append("    scheme: ").append(toIndentedString(scheme)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
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

