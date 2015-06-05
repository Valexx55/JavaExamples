package val.examples.hibernate;

public class Region {

	private long region_id;
	private String region_name;
	
	
	
	public long getRegion_id() {
		return region_id;
	}
	public void setRegion_id(long region_id) {
		this.region_id = region_id;
	}
	public String getRegion_name() {
		return region_name;
	}
	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}
	
	@Override
	public String toString() {
		return (this.region_id + this.region_name);
	}
	
	
}
