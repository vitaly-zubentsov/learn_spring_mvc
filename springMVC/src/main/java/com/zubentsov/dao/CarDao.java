package com.zubentsov.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zubentsov.util.DbUtil;
import com.zubentsov.model.Car;

public class CarDao {

	Connection connection = null;

	public CarDao() {
		connection = DbUtil.getConnection();
	}

	public void addCar(Car car) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO cars(manufacturer,model,city,registrationNumber) VALUES(?,?,?,?)");
			preparedStatement.setString(1, car.getManufacturer());
			preparedStatement.setInt(2, car.getModel());
			preparedStatement.setString(3, car.getCity());
			preparedStatement.setString(4, car.getRegistrationNumber());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteCar(int carId) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM cars WHERE carId=?");
			preparedStatement.setInt(1, carId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Car> getAllCars() {
		List<Car> cars = new ArrayList<Car>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM cars");
			while(rs.next()) {
				Car car = new Car();
				car.setCarId(rs.getInt("carId"));
				car.setManufacturer(rs.getString("manufacturer"));
				car.setModel(rs.getInt("model"));
				car.setCity(rs.getString("city"));
				car.setRegistrationNumber(rs.getString("registrationNumber"));
				cars.add(car);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cars;
	}
	
	public Car getCarById(int carId) {
		Car car = new Car();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT manufacturer, model, city, registrationNumber FROM cars WHERE carId=?");
			preparedStatement.setInt(1, carId);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				car.setCarId(carId);
				car.setManufacturer(rs.getString("manufacturer"));
				car.setModel(rs.getInt("model"));
				car.setCity(rs.getString("city"));
				car.setRegistrationNumber(rs.getString("registrationNumber"));
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return car;
	}
	
	public void updateCar(Car car) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE cars SET manufacturer=?, model=?, city=?, registrationNumber=? WHERE carId=?");
			preparedStatement.setString(1, car.getManufacturer());
			preparedStatement.setInt(2, car.getModel());
			preparedStatement.setString(3, car.getCity());
			preparedStatement.setString(4, car.getRegistrationNumber());
			preparedStatement.setInt(5, car.getCarId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
