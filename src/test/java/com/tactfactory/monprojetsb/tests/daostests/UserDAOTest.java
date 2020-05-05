package com.tactfactory.monprojetsb.tests.daostests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tactfactory.monprojetsb.dao.UserDAO;
import com.tactfactory.monprojetsb.entities.User;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
public class UserDAOTest {
	 
	@Autowired
	private UserDAO theUserDAO ; 
	
	
	@Test
	public void testInsertOne() {
		Long countBefore = this.theUserDAO.count() ; 
		this.theUserDAO.save(new User());
		Long countAfter = this.theUserDAO.count() ; 
		
		assertEquals(countBefore +1, countAfter);
	}
	
	
}
