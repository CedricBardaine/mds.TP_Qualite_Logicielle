package com.tactfactory.monprojetsb.tests.servicestests;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import com.tactfactory.monprojetsb.dao.UserDAO;
import com.tactfactory.monprojetsb.entities.Product;
import com.tactfactory.monprojetsb.entities.User;
import com.tactfactory.monprojetsb.services.UserService;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
@EntityScan(basePackages="com.tactfactory.monprojetsb")
@ComponentScan(basePackages="com.tactfactory.monprojetsb")
public class UserServiceTest {
	 
	@Autowired
	private UserDAO theUserDAO ; 
	
	@Autowired
	private UserService theUserService ; 
	
	@Test
	public void testInsertOne() {
		Long countBefore = this.theUserDAO.count() ; 
		this.theUserService.save(new User());
		Long countAfter = this.theUserDAO.count() ; 
		
		assertEquals(countBefore +1, countAfter);
	}
	
	@Test 
	public void testNotAltered() {
		User aNewUser = new User("Jean","lastname"); 
		User savedUser = this.theUserService.save(aNewUser) ;
		
		assertEquals(aNewUser, savedUser);
	}
	
	@Test
	public void correctValues() {
		User newUserTest = new User("FN","LN");
		this.theUserService.save(newUserTest); 
		
		assertEquals(
				this.theUserService.getOne(newUserTest.getId()).getFirstname() ,
				"FN"
				);
		assertEquals(
				this.theUserService.getOne(newUserTest.getId()).getLastname() ,
				"LN"
				);
		assertNull(
				this.theUserService.getOne(newUserTest.getId()).getProducts()
				);
	}
	
	@Test
	public void testDeleteOne() {
		User newUserInserted = this.theUserService.save(new User());
		
		Long countBefore = this.theUserDAO.count() ; 
		this.theUserService.deleteById(newUserInserted.getId());
		Long countAfter = this.theUserDAO.count() ; 

		assertEquals(countBefore -1, countAfter);
	}
	
		@Test
	public void testDeleteTheGoodOne() {
		User newUserInserted = this.theUserDAO.save(new User()); 
		this.theUserDAO.deleteById(newUserInserted.getId());

		assertNull(  this.theUserDAO.findById(newUserInserted.getId())  );
	}
}
