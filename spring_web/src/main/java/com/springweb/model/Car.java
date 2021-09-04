package com.springweb.model;

public class Car {
	private int carId;
	private String munufacturer;
	private int model;
	
	public int getCarId() {
		return this.carId;
	}
	
	public void setCarId(int carId) {
		this.carId= carId;
	}
	
	public String getMunufacturer() {
		return this.munufacturer;
	}
	
	public void setManufacturer(String munufacturer) {
		this.munufacturer = munufacturer;
	}
	
	public int getModel() {
		return this.model;
	}
	
	public void setModel(int Model) {
		this.model= model;
	}
	
	@Override
	public String toString() {
		return "Car [carUd=" + this.carId + " , manufacturer =" + this.munufacturer + " , model=" + this.model + "]";
	}
	
	
}
