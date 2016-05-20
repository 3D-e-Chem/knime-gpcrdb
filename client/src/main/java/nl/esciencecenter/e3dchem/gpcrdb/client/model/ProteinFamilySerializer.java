package nl.esciencecenter.e3dchem.gpcrdb.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import nl.esciencecenter.e3dchem.gpcrdb.client.model.ParentProteinFamilySerializer;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-03-25T11:18:53.274+01:00")
public class ProteinFamilySerializer   {
  
  private String slug = null;
  private String name = null;
  private ParentProteinFamilySerializer parent = null;

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("slug")
  public String getSlug() {
    return slug;
  }
  public void setSlug(String slug) {
    this.slug = slug;
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
  @JsonProperty("parent")
  public ParentProteinFamilySerializer getParent() {
    return parent;
  }
  public void setParent(ParentProteinFamilySerializer parent) {
    this.parent = parent;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProteinFamilySerializer proteinFamilySerializer = (ProteinFamilySerializer) o;
    return Objects.equals(slug, proteinFamilySerializer.slug) &&
        Objects.equals(name, proteinFamilySerializer.name) &&
        Objects.equals(parent, proteinFamilySerializer.parent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(slug, name, parent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProteinFamilySerializer {\n");
    
    sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    parent: ").append(toIndentedString(parent)).append("\n");
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

