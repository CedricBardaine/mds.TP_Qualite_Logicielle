package com.tactfactory.monprojetsb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tactfactory.monprojetsb.dao.ProductDAO;
import com.tactfactory.monprojetsb.entities.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDAO theProductDAO ; 
	
	public Product save(Product item) {
        return this.theProductDAO.save(item);
    }

    public void delete(Product item) {
        this.theProductDAO.delete(item);
    }

    public Product getOne(Long id) {
        return this.theProductDAO.getOne(id);
    }
    
    public void deleteById(Long id) {
    	this.theProductDAO.deleteById(id);
    }

    
    
    
 


}
