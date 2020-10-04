package com.data.miscellenious;

public class compareJSON {
	
	class OSN{
		
		private String legacyDistributorId;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + ((legacyDistributorId == null) ? 0 : legacyDistributorId.hashCode());
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
			OSN other = (OSN) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			if (legacyDistributorId == null) {
				if (other.legacyDistributorId != null)
					return false;
			} else if (!legacyDistributorId.equals(other.legacyDistributorId))
				return false;
			return true;
		}

		private compareJSON getEnclosingInstance() {
			return compareJSON.this;
		}
			}
	
	public static void main(String args[]) {
		String osn1 = "";
		String osn2= "";
		
	}

}
