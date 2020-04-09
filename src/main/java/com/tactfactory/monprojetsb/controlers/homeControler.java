package com.tactfactory.monprojetsb.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class homeControler {
	
	@RequestMapping(value={"/index", "/"}, method = RequestMethod.GET)
    public String handleError() {
        return "util/index";
    }
}
