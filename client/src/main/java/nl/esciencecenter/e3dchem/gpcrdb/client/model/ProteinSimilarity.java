package nl.esciencecenter.e3dchem.gpcrdb.client.model;

public class ProteinSimilarity {
	private Integer similarity = null;
	private Integer identity = null;
	private String AA = null;

	public Integer getSimilarity() {
		return similarity;
	}

	public void setSimilarity(Integer similarity) {
		this.similarity = similarity;
	}

	public Integer getIdentity() {
		return identity;
	}

	public void setIdentity(Integer identity) {
		this.identity = identity;
	}

	public String getAA() {
		return AA;
	}

	public void setAA(String aA) {
		AA = aA;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((AA == null) ? 0 : AA.hashCode());
		result = prime * result + ((identity == null) ? 0 : identity.hashCode());
		result = prime * result + ((similarity == null) ? 0 : similarity.hashCode());
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
		ProteinSimilarity other = (ProteinSimilarity) obj;
		if (AA == null) {
			if (other.AA != null)
				return false;
		} else if (!AA.equals(other.AA))
			return false;
		if (identity == null) {
			if (other.identity != null)
				return false;
		} else if (!identity.equals(other.identity))
			return false;
		if (similarity == null) {
			if (other.similarity != null)
				return false;
		} else if (!similarity.equals(other.similarity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProteinSimilarity [similarity=" + similarity + ", identity=" + identity + ", AA=" + AA + "]";
	}
}
