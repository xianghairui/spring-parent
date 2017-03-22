package com.xiang.spring.ioc.beans.spel;

public class Person {

	private String name;
	private Car car;
	private String city;
	
	//根据car确定info
	private String info;
	
	public Person() {
		super();
	}

	public Person(String name, Car car, String city, String info) {
		super();
		this.name = name;
		this.car = car;
		this.city = city;
		this.info = info;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", car=" + car + ", city=" + city + ", info=" + info + "]";
	}


	


}
