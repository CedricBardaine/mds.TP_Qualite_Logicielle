package com.tactfactory.monprojetsb.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tactfactory.monprojetsb.dao.ProductDAO;
import com.tactfactory.monprojetsb.dao.UserDAO;
import com.tactfactory.monprojetsb.entities.Product;
import com.tactfactory.monprojetsb.entities.User;

@Controller
@RequestMapping(value= {"product"})
public class ProductControler implements genericControler {
	
	   @Autowired
	    private ProductDAO theProductDao;

	@Override
	@RequestMapping(value={"/index", "/"}, method = RequestMethod.GET)
	   public String index(Model model) {
		model.addAttribute("page" , "index for Product");
		model.addAttribute("items", theProductDao.findAll());
		return "product/index";
		
	}

	@Override
	@GetMapping(value={"/create"}) 
	public String createGet() {
		return "product/create";
	}

	@Override
	public String createPost() {
		return null;
		// TODO Auto-generated method stub
	}
	
	@PostMapping(value="/create")
	public void createPost(@RequestParam("name") String name , @RequestParam("price") float price) {
		theProductDao.save(new Product(name, price));
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
