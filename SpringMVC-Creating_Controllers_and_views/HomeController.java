package springDemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//create a controller class 
@Controller    //add the @controller annotation

//create a method
public class HomeController
{
	  //add request mapping to the controller method
	  @RequestMapping("/")	
      public String viewpage()
      {
    	return "main-menu";  //return view name  
    	//Web-Inf(prefix)/view/main-menu(view name).jsp(suffix)
    	
      }
}
