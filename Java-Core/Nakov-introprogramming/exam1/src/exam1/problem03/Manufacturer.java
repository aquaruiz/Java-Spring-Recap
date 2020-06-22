package exam1.problem03;

public class Manufacturer {
	private String name;
	private String country;
	private String address;
	private String phone;
	private String fax;
	
	public Manufacturer(String name, String country, String address, String phone, String fax) {
		this.name = name;
		this.country = country;
		this.address = address;
		this.phone = phone;
		this.fax = fax;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s, %s (%s)", this.name, this.country, this.address, this.phone);
	}
}
