package com.tactfactory.monprojetsb.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tactfactory.monprojetsb.dao.UserDAO;
import com.tactfactory.monprojetsb.entities.User;

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
	public String createPost(Model model, @RequestParam("firstname") String fn , @RequestParam("lastname") String ln ) {
		if (fn != "" && ln != "" ) {
			theUserDao.save(new User(fn, ln));
			setIndexAttributs(model);
			return "user/index";
		}
		else {
			model.addAttribute("back" , "/user/create");
			return "util/badInput";
		}
	}

	@Override
	@PostMapping(value="/delete")
	public String delete(Model model, @RequestParam("id") Long id ) {
		setIndexAttributs(model);
		
		if (id != null) 
			theUserDao.deleteById(id);
		return "user/index" ; 
	}

	@Override
	public void details() {
		// TODO Auto-generated method stub
		
	}
	
	private void setIndexAttributs(Model model) {
		model
		.addAttribute("page", "index for User")
		.addAttribute("items", theUserDao.findAll());
	}



}
