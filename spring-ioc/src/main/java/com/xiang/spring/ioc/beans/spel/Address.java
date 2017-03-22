package com.xiang.spring.ioc.beans.spel;

public class Address {
	
	private String city;
	private String street;
	
	public Address() {
	}
	public Address(String city, String street) {
		super();
		this.city = city;
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	@Override
	public String toString() {
		return "Adress [city=" + city + ", street=" + street + "]";
	}
	
	
	
}
