package com.tactfactory.monprojetsb.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mapping.model.IdPropertyIdentifierAccessor;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.tactfactory.monprojetsb.MonprojetsbApplication;
import com.tactfactory.monprojetsb.MonprojetsbApplicationTests;
import com.tactfactory.monprojetsb.dao.ProductDAO;
import com.tactfactory.monprojetsb.dao.UserDAO;
import com.tactfactory.monprojetsb.entities.Product;
import com.tactfactory.monprojetsb.entities.User;
import com.tactfactory.monprojetsb.services.ProductService;
import com.tactfactory.monprojetsb.services.UserService;

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
import com.tactfactory.monprojetsb.entities.User;
import com.tactfactory.monprojetsb.services.UserService;

//@RunWith(SpringRunner.class)
//@AutoConfigureTestDatabase(replace = Replace.NONE)
//@DataJpaTest
//@EntityScan(basePackages="com.tactfactory.monprojetsb")
//@ComponentScan(basePackages="com.tactfactory.monprojetsb")
@ActiveProfiles("test")
@TestPropertySource(locations = { "classpath:applicationtest.properties" })
@SpringBootTest(classes = MonprojetsbApplicationTests.class)
public class ProductServiceTest {
	
	@Autowired
	private ProductDAO theProductDAO ; 
	

	@Autowired
	private ProductService theProductService ; 
	
	
//	// !!!! Before & After must be statics
//	@BeforeClass
//    public void setup() {
//		Product insertedProduct = this.theProductDAO.save( new Product("BeforeInsertProductTest", (float)7.7) );
//		this.idTestProduct = insertedProduct.getId() ;
//    }
// 
//    @AfterClass
//    public void tearDown() {
//    	this.theProductDAO.deleteById(this.idTestProduct);
//    }


	@Test
	public void testInsertOne() {
		Long countBefore = this.theProductDAO.count() ; 
		this.theProductService.save(new Product());
		Long countAfter = this.theProductDAO.count() ; 

		assertEquals(countBefore +1, countAfter);
	}

	@Test 
	public void testNotAltered() {
		Product aNewProduct = new Product("nameProduct", (float)50.2); 
		Product savedProduct = this.theProductService.save(aNewProduct) ;

		assertEquals(aNewProduct, savedProduct);
	}
	
	
	
//	/**
//	 * @deprecated
//	 */
//	@Test 
//	public void testUpdateNotAlter() {
//		Product productNotModified = this.theProductService.getOne(idTestProduct);
//		
//		Product productModifiing  = this.theProductService.getOne(idTestProduct);
//		productModifiing.setName("newName") ; 
//		this.theProductService.save(productModifiing);
//		
//		Product productModified = this.theProductService.getOne(productModifiing.getId());
//		
//		assertNotNull(productModified);
//	}
	
//	/**
//	 * @deprecated
//	 */
//	@Test
//	public void correctValues() {
//		assertEquals(this.theProductService.getOne(this.idTestProduct).getName(), "BeforeInsertProductTest");
//	}
	
	@Test
	public void correctValues() {
		Product newProductTest = new Product("ProductTest" , (float)7.7);
		this.theProductService.save(newProductTest); 
		
		assertEquals(
				this.theProductService.getOne(newProductTest.getId()).getName() ,
				"ProductTest"
				);
		assertEquals(
				this.theProductService.getOne(newProductTest.getId()).getPrice() ,
				(float)7.7
				);
	}
	
	@Test
	public void testDeleteOne() {
		Product newProductInserted = this.theProductService.save(new Product());
		
		Long countBefore = this.theProductDAO.count() ; 
		this.theProductService.deleteById(newProductInserted.getId());
		Long countAfter = this.theProductDAO.count() ; 

		assertEquals(countBefore -1, countAfter);
	}
	
		@Test
	public void testDeleteTheGoodOne() {
		Product newProductInserted = this.theProductDAO.save(new Product()); 
		this.theProductDAO.deleteById(newProductInserted.getId());

		assertNull(  this.theProductDAO.findById(newProductInserted.getId())  );
	}
}
