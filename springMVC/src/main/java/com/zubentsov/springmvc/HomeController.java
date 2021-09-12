package com.zubentsov.springmvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.zubentsov.dao.CarDao;
import com.zubentsov.model.Car;





/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@Autowired
	CarDao dao; //will inject dao from fileservlet-context.xml
	
	/* Displays a form to input data. "command" is a reserved request attribute,
	 * which is used to display object data into the form.
	 */
	@RequestMapping("/addCar")
	public ModelAndView showform() {
		return new ModelAndView("addCar","command", new Car());
	}
	
	/* Saves object into database. The @ModelAttribute puts request data into the model object,
	 * You need to mention RequestMethod.POST because the default request is GET
	 */
	@RequestMapping(value = "/addCar", method= RequestMethod.POST)
	public ModelAndView save(@ModelAttribute(" ") Car car) {
		dao.addCar(car);
		return new ModelAndView("redirect:/viewCars"); // will redirect to view cars request mapping
	}
		
	//provides list of cars in model object
	@RequestMapping("/viewCars")
	public ModelAndView viewCars() {
		List<Car> list = dao.getAllCars();
		return new ModelAndView("viewCars", "list", list);
	}
	
	/* displays object data into form for given car Id.
	 * The @PathVariable puts URL data into the variable.
	 */
	@RequestMapping(value="/editCar/{carId}") 
	public ModelAndView edit(@PathVariable int carId) {
		Car car = dao.getCarById(carId);
		return new ModelAndView("editCar", "command", car);
	}
	
	//updates model object
	@RequestMapping(value="/editAndSave", method=RequestMethod.POST)
	public ModelAndView editAndSave(@ModelAttribute("car") Car car) {
		dao.updateCar(car);
		return new ModelAndView("redirect:/viewCars");
	}
	
	//deletes record for given Car Id in the URL and redirects to /viewCar
	@RequestMapping("/deleteCar/{carId}")
	public ModelAndView delete(@PathVariable int carId) {
		dao.deleteCar(carId);
		return new ModelAndView("redirect:/viewCars");
	}
	
	
	
	
}
