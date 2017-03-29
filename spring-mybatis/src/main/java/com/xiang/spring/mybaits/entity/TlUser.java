package com.xiang.spring.mybaits.entity;

public class TlUser {
	
	private Integer id;
	
	private String username;
	
	private String gender;
	
	private Integer age;
	
	private String adress;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	@Override
	public String toString() {
		return "TlUser [id=" + id + ", username=" + username + ", gender=" + gender + ", age=" + age + ", adress="
				+ adress + "]";
	}
	
	
	
}
