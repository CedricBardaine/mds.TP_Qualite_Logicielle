package com.tactfactory.monprojetsb.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.tactfactory.monprojetsb.entities.Product;

public class ProductService {

	@Autowired
	private ProductService theProductService ; 
	
	public Product save(Product item) {
        return this.theProductService.save(item);
    }

    public void delete(Product item) {
        this.theProductService.delete(item);
    }

    public Product getOne(Long id) {
        return this.theProductService.getOne(id);
    }


}
