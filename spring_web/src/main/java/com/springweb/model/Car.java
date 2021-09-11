package com.springweb.model;

public class Car {
	private int carId;
	private String manufacturer;
	private int model;
	
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
	
	@Override
	public String toString() {
		return "Car [carUd=" + this.carId + " , manufacturer =" + this.manufacturer + " , model=" + this.model + "]";
	}
	
	
}
