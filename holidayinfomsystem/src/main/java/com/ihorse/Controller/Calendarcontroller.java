package com.ihorse.Controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
/*import org.springframework.web.bind.annotation.ModelAttribute;*/
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
/*import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;*/
import org.springframework.web.servlet.ModelAndView;

import com.ihorse.DaoImpl.Calendardaoimpl;
import com.ihorse.Dto.Calendardto;
import com.ihorse.Pojo.Calendarbean;
import com.ihorse.ServiceImpl.Calendarserviceimpl;

@Controller
public class Calendarcontroller {

	@Autowired
	Calendardaoimpl cdao;
	@Autowired
	Calendarserviceimpl cservice;
	private static final Logger logger = Logger.getLogger(Calendarcontroller.class);

	// @RequestMapping(value = "/test", method = RequestMethod.GET)
	public String displayLogin(Model model) {
		model.addAttribute("done", new Calendarbean());
		return "calendar";
	}

	@RequestMapping("/index")
	public ModelAndView Success() {

		return new ModelAndView("redirect:/index");
	}

	/*
	 * @RequestMapping("/test") public String showform(Model model) { // public
	 * ModelAndView showform(Model model) { // return new
	 * ModelAndView("calendar", "enter", new Calendarbean()); // return new
	 * ModelAndView("calendar", "enter", new Calendarbean());
	 * model.addAttribute("calendar", new Calendarbean()); return "calendar"; }
	 */
	@SuppressWarnings("deprecation")
	/*
	 * Working @RequestMapping(value = "/store", method = RequestMethod.POST,
	 * produces = MediaType.APPLICATION_JSON, consumes =
	 * MediaType.APPLICATION_JSON, headers = "Accept=application/json")
	 * public @ResponseBody String save(@RequestBody Calendarbean om) throws
	 * SQLException { // public @ResponseBody String save(String id) throws
	 * SQLException { // return id; String s = om.getName(); // String n=name;
	 * 
	 * System.out.println(s); // cdao.save(enter); // return new
	 * ModelAndView("redirect:/addDetails"); return "redirect:/addDetails"; }
	 */
	/*@RequestMapping(value = "/store", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
	public @ResponseBody ModelAndView Submit(@RequestParam("name") String name, @RequestParam("sd") Date sd,
			@RequestParam("ed") Date ed, @RequestParam("des") String des, Calendarbean os)
			throws SQLException, ParseException {

		cdao.save(os);

		// Calendardto s = cservice.Proce(Name, start_date, end_date,
		// description);

		return new ModelAndView("redirect:/addDetails");
	}*/
	
	@RequestMapping(value = "/store", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, consumes = "application/json", headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody Calendardto Submit(@RequestBody Calendarbean os)
			throws SQLException, ParseException {
		cdao.save(os);
		return new Calendardto();
	}

	/*
	 * @RequestMapping(value = "/om", method = RequestMethod.POST, produces =
	 * MediaType.APPLICATION_JSON, consumes = "application/json", headers =
	 * "content-type=application/x-www-form-urlencoded") public @ResponseBody
	 * List<Calendarbean> De(@RequestBody Calendarbean s) throws SQLException,
	 * ParseException { System.out.println(s.getMonth());
	 * System.out.println(s.getYear()); System.out.println(s.getSd());
	 * List<Calendarbean> data = cdao.userDetails(s.getMonth(), s.getYear(),
	 * s.getSd());
	 * 
	 * return data;
	 * 
	 * }
	 */

	@RequestMapping(value = "/om", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, consumes = "application/json", headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody Calendardto success(@RequestBody Calendarbean s) throws SQLException, ParseException {
		System.out.println(s.getMonth());
		System.out.println(s.getYear());
		System.out.println(s.getSd());

		// Calendardto om = new Calendardto();
		// List<Calendarbean> data = cdao.userDetails(s.getMonth(), s.getYear(),
		// s.getSd());
		// om.setListCbean(data);

		/*
		 * Calendardto raw = cservice.Proce(s.getMonth(), s.getYear(),
		 * s.getSd());
		 * System.out.println("this is from service layer"+raw.getStartDate());
		 */
		return cservice.Proce(s.getMonth(), s.getYear(), s.getSd());

	}

	@RequestMapping(value = "/deleteRecords", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, consumes = "application/json", headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody Calendardto deleteRecords(@RequestBody List<Calendarbean> cbList)
			throws SQLException, ParseException {
		cservice.delDates(cbList);
		return new Calendardto();
	}

}
