package com.tactfactory.monprojetsb.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tactfactory.monprojetsb.dao.UserDAO;

@Controller
@RequestMapping(value="user")
public class UserControler implements genericControler {
	
    @Autowired
    private UserDAO theUserDao;



    @Override
    @RequestMapping(value={"/index", "/"}, method = RequestMethod.GET)
    public String index(Model model) {
    	model.addAttribute("page", "index for User");
    	model.addAttribute("items", theUserDao.findAll());
    	return "user/index";		
    }

    @Override
    @RequestMapping(value={"/create"}, method = RequestMethod.GET)
    public String createGet() {
    	return "user/create";	

    }
    
	@Override
	public String createPost() {
		return "util/error"; 
	}
	
	@RequestMapping(value={"/create"}, method = RequestMethod.POST)
	public void createPost(@RequestParam("firstname") String fn , @RequestParam("lastname") String ln ) {
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void details() {
		// TODO Auto-generated method stub
		
	}



}
