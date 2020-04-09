package com.tactfactory.monprojetsb.controlers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class errorControler implements ErrorController {

	@RequestMapping("/error")
    public String handleError() {
        return "util/error";
    }
	
	
	@Override
	public String getErrorPath() {
		return "/util/error" ; 
	}
}