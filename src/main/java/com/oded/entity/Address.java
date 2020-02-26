package com.oded.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Address")

public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String address;
	public int getId() {
		return id;
	}
	public Address(String address) {
		super();
		this.address = address;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", address=" + address + "]";
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
