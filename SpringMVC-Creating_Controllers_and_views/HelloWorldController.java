package springDemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//add the @Controller Annotation
@Controller
//parentmapping
@RequestMapping("/hello")
public class HelloWorldController 
{
	// need a controller method to show the initial HTML form
	
	@RequestMapping("/showForm")
	public String showForm()
	{
		return "helloworld-form";
	}
	
	//need a controller method to process the html form
	
	@RequestMapping("/processForm")
	public String processForm()
	{
		return "helloworld";
	}
	
	
	//add a new controller method to read form data and add data to the model
	
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request,Model model)
	{
		//read the request paramters from the HTML form
		
		String theName = request.getParameter("studentName");
		
		//convert all to caps
		
		theName = theName.toUpperCase();
		
		//create the message
		
		String result = "Yo!"+theName;
		
		//add that message to the model
		
		model.addAttribute("message",result);
		
		return "helloworld";
		
	}
	
	//@RequestParam
	@RequestMapping("/processFormVersionThree")
	public String letsShoutDude(@RequestParam String studentName,Model model)
	{
		
		//convert all to caps
		
		studentName = studentName.toUpperCase();
		
		//create the message
		
		String result = "Yo!"+studentName;
		
		//add that message to the model
		
		model.addAttribute("message",result);
		
		return "helloworld";
		
	}
}
