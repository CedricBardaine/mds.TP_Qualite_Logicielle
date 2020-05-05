package com.tactfactory.monprojetsb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tactfactory.monprojetsb.dao.UserDAO;
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

}
