package test.web;

import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import test.model.MyModel;

@Controller
public class TestController {

	/**
	 * This method will return JSON.
	 * @return
	 */
	@RequestMapping(value="/greeting", method=RequestMethod.GET)
	public @ResponseBody MyModel greeting() {
		MyModel model = new MyModel();
		model.setMessage("Hello from " + getClass().getName() + " // " +UUID.randomUUID());
		return model;
	}
	
	/**
	 * This method will return a path to a JSP.
	 * @return
	 */
	@RequestMapping(value="/greetingJSP", method=RequestMethod.GET)
	public String greetingJSP(Model model) {
		
		MyModel mymodel = new MyModel();
		mymodel.setMessage("Hello.......");
		
		// You can pass these back to the view layer
		model.addAttribute("classBeingCalled", getClass().getName());
		model.addAttribute("currentDate", new Date());
		model.addAttribute("myModel", mymodel);
		
		return "greetingJSP";
	}
}
