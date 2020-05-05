package com.tactfactory.monprojetsb.tests.servicestests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tactfactory.monprojetsb.dao.ProductDAO;
import com.tactfactory.monprojetsb.dao.UserDAO;
import com.tactfactory.monprojetsb.entities.Product;
import com.tactfactory.monprojetsb.entities.User;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
public class ProductServiceTest {
	@Autowired
	private ProductDAO theProductDAO ; 


	@Test
	public void testInsertOne() {
		Long countBefore = this.theProductDAO.count() ; 
		this.theProductDAO.save(new Product());
		Long countAfter = this.theProductDAO.count() ; 

		assertEquals(countBefore +1, countAfter);
	}

	@Test 
	public void testNotAltered() {
		Product aNewProduct = new Product("nameProduct", (float)50.2); 
		Product savedProduct = this.theProductDAO.save(aNewProduct) ;

		assertEquals(aNewProduct, savedProduct);
	}
}
