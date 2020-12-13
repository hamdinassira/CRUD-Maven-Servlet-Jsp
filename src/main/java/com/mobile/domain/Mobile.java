package com.mobile.domain;

public class Mobile {
	private int mobile_id;
	private String reference;
	private String brand;
	private Float price;
	

	public int getMobile_id() {
		return mobile_id;
	}


	public void setMobile_id(int mobile_id) {
		this.mobile_id = mobile_id;
	}


	public String getReference() {
		return reference;
	}


	public void setReference(String reference) {
		this.reference = reference;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public Float getPrice() {
		return price;
	}


	public void setPrice(Float price) {
		this.price = price;
	}


	public Mobile( String reference, String brand, Float price) {
		super();
		
		this.reference = reference;
		this.brand = brand;
		this.price = price;
	}


	@Override
	public String toString() {
		return mobile_id + ","  + reference + "," + brand + ", " + price ;
	}

	
}
