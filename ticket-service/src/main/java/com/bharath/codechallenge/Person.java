package com.bharath.codechallenge;

public class Person {

	private int age;
	private String location;
	private String gender;
	private long salary;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public Person(int age, String location, String gender, long salary) {
		super();
		this.age = age;
		this.location = location;
		this.gender = gender;
		this.salary = salary;
	}
	
	
	
	
	
}
