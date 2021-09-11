package com.zubentsov.model;

public class Car {

	private int carId;
	private String manufacturer;
	private int model;
	private String city;
	private String registrationNumber;
	
	
	public int getCarId() {
		return this.carId;
	}
	
	public void setCarId(int carId) {
		this.carId= carId;
	}
	
	public String getManufacturer() {
		return this.manufacturer;
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public int getModel() {
		return this.model;
	}
	
	public void setModel(int model) {
		this.model= model;
	}
	
	
	public String getCity() {
		return this.city;
	}
	
	public void setCity(String city) {
		this.city= city;
	}
	
	
	public String getRegistrationNumber() {
		return this.registrationNumber;
	}
	
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber= registrationNumber;
	}
	
	
	@Override
	public String toString() {
		return "Car [carUd=" + this.carId + " , manufacturer =" + this.manufacturer + " , model=" + this.model + "]";
	}
	
}
