package ca.horse.core.data;

public class LocationSearchCriteria {
	private String cd;
	private String name;
	private String address;
	
	private LocationSearchCriteria(LocationSearchCriteriaBuilder builder) {
		this.cd = builder.cd;
		this.name = builder.name;
		this.address = builder.address;
	}
	
	public String getCd() {
		return cd;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public static class LocationSearchCriteriaBuilder{
		private String cd;
		private String name;
		private String address;

		public LocationSearchCriteriaBuilder() {}
		
		public LocationSearchCriteria build() {
			return new LocationSearchCriteria(this);
		}
		
		public LocationSearchCriteriaBuilder setCd(String cd) {
			this.cd = cd;
			return this;
		}

		public LocationSearchCriteriaBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public LocationSearchCriteriaBuilder setAddress(String address) {
			this.address = address;
			return this;
		}
		
		
		
	}
}
