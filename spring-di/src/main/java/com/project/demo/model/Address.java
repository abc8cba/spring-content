package com.project.demo.model;

public class Address {

	private String countryName;
	private String stateName;
	private String cityName;
	private String pincode;
	private String landmark;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String countryName, String stateName, String cityName, String pincode, String landmark) {
		super();
		this.countryName = countryName;
		this.stateName = stateName;
		this.cityName = cityName;
		this.pincode = pincode;
		this.landmark = landmark;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	@Override
	public String toString() {
		return "Address [countryName=" + countryName + ", stateName=" + stateName + ", cityName=" + cityName
				+ ", pincode=" + pincode + ", landmark=" + landmark + "]";
	}

}
