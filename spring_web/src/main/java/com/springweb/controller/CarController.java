package com.springweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springweb.dao.CarDao;
import com.springweb.model.Car;

public class CarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String LIST_OF_USER = "/listCar.jsp";
	private String INSERT_OR_EDIT = "/car.jsp";
	private CarDao dao;
	private ApplicationContext context;

	public CarController() {
		context = new ClassPathXmlApplicationContext("spring.xml");
		dao = (CarDao) context.getBean("carDao");
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("delete")) {
			dao.deleteCar(Integer.parseInt(request.getParameter("carId")));
			forward = LIST_OF_USER;
			request.setAttribute("cars", dao.getAllCars());
		} else if (action.equalsIgnoreCase("edit")) {
			forward = INSERT_OR_EDIT;
			Car car = dao.getCarById(Integer.parseInt(request.getParameter("carId")));
			request.setAttribute("car", car);
		} else if (action.equalsIgnoreCase("listCar")) {
			forward = LIST_OF_USER;
			request.setAttribute("cars", dao.getAllCars());
		} else {
			forward = INSERT_OR_EDIT;
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Car car = (Car) context.getBean("car");
		car.setManufacturer(request.getParameter("manufacturer"));
		car.setModel(Integer.parseInt(request.getParameter("model")));
		String carId = request.getParameter("carId");
		
		
		if (carId==null || carId.isEmpty()) {
			dao.addCar(car);
		} else {
		car.setCarId(Integer.parseInt(carId));
		dao.updateCar(car);
		}
		 RequestDispatcher view = request.getRequestDispatcher(LIST_OF_USER);
	        request.setAttribute("cars", dao.getAllCars());
	        view.forward(request, response);
	}

}
