package com.tactfactory.monprojetsb.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tactfactory.monprojetsb.dao.ProductDAO;
import com.tactfactory.monprojetsb.entities.Product;

@Controller
@RequestMapping(value= {"product"})
public class ProductControler implements genericControler {
	
	   @Autowired
	    private ProductDAO theProductDao;

	@Override
	@RequestMapping(value={"/index", "/"}, method = RequestMethod.GET)
	   public String index(Model model) {
		setIndexAttributs(model);
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
	public String createPost(Model model, @RequestParam("name") String name , @RequestParam("price") float price) {
		if (name != "" && String.valueOf(price) != "" ) {
			theProductDao.save(new Product(name, price));
			setIndexAttributs(model);
			return "product/index" ;
		}
		else {
			model.addAttribute("back" , "/product/create");
			return "util/badInput";
		}
	}

	@Override
	@PostMapping(value="/delete")
	public String delete(Model model, @RequestParam("id") Long id ) {
		setIndexAttributs(model);
		
		if (id != null) 
			theProductDao.deleteById(id);
		return "product/index" ; 
	}

	@Override
	@GetMapping(value="/show/{id}")
	public String details(Model model, @PathVariable long id) {
		String ret = "product/show";
		model.addAttribute("page", "Product Details");
		
		if ( theProductDao.findById(id).isPresent() )
			model.addAttribute("item", theProductDao.findById(id).get());
		else 
			ret = "util/badInput" ;
		
		return ret ;
	}
	
	private void setIndexAttributs(Model model) {
		model
		.addAttribute("page" , "index for Product")
		.addAttribute("items", theProductDao.findAll());
	}




	
}
