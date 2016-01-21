package nl.esciencecenter.e3dchem.gpcrdb.client.model;

import java.util.List;

public class Structure {
	private String publication = null;
	private Float resolution = null;
	private String type = null;
	private String preferred_chain = null;
	private String pdb_code = null;
	private List<Ligand> ligands = null;
	private String protein = null;
	private String family = null;
	private String publication_date = null;
	private String species = null;

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public Float getResolution() {
		return resolution;
	}

	public void setResolution(Float resolution) {
		this.resolution = resolution;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPreferred_chain() {
		return preferred_chain;
	}

	public void setPreferred_chain(String preferred_chain) {
		this.preferred_chain = preferred_chain;
	}

	public String getPdb_code() {
		return pdb_code;
	}

	public void setPdb_code(String pdb_code) {
		this.pdb_code = pdb_code;
	}

	public List<Ligand> getLigands() {
		return ligands;
	}

	public void setLigands(List<Ligand> ligands) {
		this.ligands = ligands;
	}

	public String getProtein() {
		return protein;
	}

	public void setProtein(String protein) {
		this.protein = protein;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getPublication_date() {
		return publication_date;
	}

	public void setPublication_date(String publication_date) {
		this.publication_date = publication_date;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((family == null) ? 0 : family.hashCode());
		result = prime * result + ((ligands == null) ? 0 : ligands.hashCode());
		result = prime * result + ((pdb_code == null) ? 0 : pdb_code.hashCode());
		result = prime * result + ((preferred_chain == null) ? 0 : preferred_chain.hashCode());
		result = prime * result + ((protein == null) ? 0 : protein.hashCode());
		result = prime * result + ((publication == null) ? 0 : publication.hashCode());
		result = prime * result + ((publication_date == null) ? 0 : publication_date.hashCode());
		result = prime * result + ((resolution == null) ? 0 : resolution.hashCode());
		result = prime * result + ((species == null) ? 0 : species.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Structure other = (Structure) obj;
		if (family == null) {
			if (other.family != null)
				return false;
		} else if (!family.equals(other.family))
			return false;
		if (ligands == null) {
			if (other.ligands != null)
				return false;
		} else if (!ligands.equals(other.ligands))
			return false;
		if (pdb_code == null) {
			if (other.pdb_code != null)
				return false;
		} else if (!pdb_code.equals(other.pdb_code))
			return false;
		if (preferred_chain == null) {
			if (other.preferred_chain != null)
				return false;
		} else if (!preferred_chain.equals(other.preferred_chain))
			return false;
		if (protein == null) {
			if (other.protein != null)
				return false;
		} else if (!protein.equals(other.protein))
			return false;
		if (publication == null) {
			if (other.publication != null)
				return false;
		} else if (!publication.equals(other.publication))
			return false;
		if (publication_date == null) {
			if (other.publication_date != null)
				return false;
		} else if (!publication_date.equals(other.publication_date))
			return false;
		if (resolution == null) {
			if (other.resolution != null)
				return false;
		} else if (!resolution.equals(other.resolution))
			return false;
		if (species == null) {
			if (other.species != null)
				return false;
		} else if (!species.equals(other.species))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Structure [publication=" + publication + ", resolution=" + resolution + ", type=" + type
				+ ", preferred_chain=" + preferred_chain + ", pdb_code=" + pdb_code + ", ligands=" + ligands
				+ ", protein=" + protein + ", family=" + family + ", publication_date=" + publication_date
				+ ", species=" + species + "]";
	}

}
