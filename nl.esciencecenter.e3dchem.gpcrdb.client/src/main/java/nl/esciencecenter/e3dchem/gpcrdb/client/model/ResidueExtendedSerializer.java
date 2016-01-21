package nl.esciencecenter.e3dchem.gpcrdb.client.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-01-19T13:05:55.822+01:00")
public class ResidueExtendedSerializer {

	private Integer sequenceNumber = null;
	private String aminoAcid = null;
	private String proteinSegment = null;
	private String displayGenericNumber = null;
	private List<AlternativeGenericNumber> alternativeGenericNumbers = new ArrayList<AlternativeGenericNumber>();

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

	/**
	 **/

	@ApiModelProperty(required = true, value = "")
	@JsonProperty("protein_segment")
	public String getProteinSegment() {
		return proteinSegment;
	}

	public void setProteinSegment(String proteinSegment) {
		this.proteinSegment = proteinSegment;
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
	@JsonProperty("alternative_generic_numbers")
	public List<AlternativeGenericNumber> getAlternativeGenericNumbers() {
		return alternativeGenericNumbers;
	}

	public void setAlternativeGenericNumbers(List<AlternativeGenericNumber> alternativeGenericNumbers) {
		this.alternativeGenericNumbers = alternativeGenericNumbers;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResidueExtendedSerializer residueExtendedSerializer = (ResidueExtendedSerializer) o;
		return Objects.equals(sequenceNumber, residueExtendedSerializer.sequenceNumber)
				&& Objects.equals(aminoAcid, residueExtendedSerializer.aminoAcid)
				&& Objects.equals(proteinSegment, residueExtendedSerializer.proteinSegment)
				&& Objects.equals(displayGenericNumber, residueExtendedSerializer.displayGenericNumber)
				&& Objects.equals(alternativeGenericNumbers, residueExtendedSerializer.alternativeGenericNumbers);
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
	private String toIndentedString(Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
