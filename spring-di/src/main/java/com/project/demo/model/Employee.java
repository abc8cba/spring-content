package com.project.demo.model;

public class Employee {

	private int id;
	private Name name;
	private Address address;

	public Employee(int id, Name name, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public Employee() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

}
