package com.tactfactory.monprojetsb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tactfactory.monprojetsb.dao.UserDAO;
import com.tactfactory.monprojetsb.entities.Product;
import com.tactfactory.monprojetsb.entities.User;

/**
 * An adapter to the {@link UserDAO} class.
 * @author cedri
 *
 */
@Service
public class UserService {
	
	@Autowired
	private UserDAO theUserDAO;


	public User save(User item) {
        return this.theUserDAO.save(item);
    }

    public void delete(User item) {
        this.theUserDAO.delete(item);
    }

    public User getOne(Long id) {
        return this.theUserDAO.getOne(id);
    }
    
    /**
     * 
     * @param id the id of the User to update
     * @param fn the new firstName
     * @param ln the new lastName
     * @param products the new List of Products
     * @return the updated User
     */
    public User update(Long id, String fn, String ln, List<Product> products) {
    	User updatingUser = this.theUserDAO.getOne(id);
    	updatingUser.setFirstname(fn);
    	updatingUser.setLastname(ln);
    	updatingUser.setProducts(products);
    	
    	this.theUserDAO.flush();
    	
    	return updatingUser;
    	
    }

	public void deleteById(Long id) {
		this.theUserDAO.deleteById(id);
	}

}
