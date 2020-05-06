package com.tactfactory.monprojetsb.services;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.tactfactory.monprojetsb.MonprojetsbApplicationTests;
import com.tactfactory.monprojetsb.dao.UserDAO;
import com.tactfactory.monprojetsb.entities.Product;
import com.tactfactory.monprojetsb.entities.User;
import com.tactfactory.monprojetsb.services.UserService;
import com.tactfactory.monprojetsb.tests.mocks.MockitoUser;

//@RunWith(SpringRunner.class)
//@AutoConfigureTestDatabase(replace = Replace.NONE)
//@DataJpaTest
//@EntityScan(basePackages="com.tactfactory.monprojetsb")
//@ComponentScan(basePackages="com.tactfactory.monprojetsb")
@ActiveProfiles("test")
@TestPropertySource(locations = { "classpath:application-test.properties" })
@SpringBootTest(classes = MonprojetsbApplicationTests.class)
public class UserServiceTest {

	@Autowired
	private UserService theUserService;

	@MockBean
	private UserDAO theUserRepository;

	private User entity;

	@BeforeEach
	public void setUp() throws Exception {
		final MockitoUser mock = new MockitoUser(this.theUserRepository);
		mock.intialize();
		this.entity = mock.entity;
	}

//	/**
//	 * Test d'exemple
//	 */
//	@Test
//	public void Test1() {
//		long before = theUserRepository.count();
//		theUserService.save(this.entity);
//		long after = theUserRepository.count();
////		assertEquals(before + 1, after);
//		
//		long before2 = theUserRepository.count();
//		theUserService.save(this.entity);
//		theUserService.save(this.entity);
//		long after2 = theUserRepository.count();
//		assertEquals(before + 2, after);
//	}
	/**
	 * Test d'exemple
	 */
	@Test
	public void Test1() {
		long before = theUserRepository.count();
		theUserRepository.save(this.entity);
		long after = theUserRepository.count();
//		assertEquals(before + 1, after);
		
		long before2 = theUserRepository.count();
		theUserRepository.save(this.entity);
		theUserRepository.save(this.entity);
		long after2 = theUserRepository.count();
		assertEquals(before + 2, after);
	}

	@Test
	public void testInsertOne() {
		Long countBefore = this.theUserRepository.count();
		this.theUserService.save(new User());
		Long countAfter = this.theUserRepository.count();

		assertEquals(countBefore + 1, countAfter);
	}

	@Test
	public void testNotAltered() {
		User aNewUser = new User("Jean", "lastname");
		User savedUser = this.theUserService.save(aNewUser);

		assertEquals(aNewUser, savedUser);
	}

	@Test
	public void correctValues() {
		User newUserTest = new User("FN", "LN");
		this.theUserService.save(newUserTest);

		assertEquals(this.theUserService.getOne(newUserTest.getId()).getFirstname(), "FN");
		assertEquals(this.theUserService.getOne(newUserTest.getId()).getLastname(), "LN");
		assertNull(this.theUserService.getOne(newUserTest.getId()).getProducts());
	}

	@Test
	public void testDeleteOne() {
		User newUserInserted = this.theUserService.save(new User());

		Long countBefore = this.theUserRepository.count();
		this.theUserService.deleteById(newUserInserted.getId());
		Long countAfter = this.theUserRepository.count();

		assertEquals(countBefore - 1, countAfter);
	}

	@Test
	public void testDeleteTheGoodOne() {
		User newUserInserted = this.theUserRepository.save(new User());
		this.theUserRepository.deleteById(newUserInserted.getId());

		assertNull(this.theUserRepository.findById(newUserInserted.getId()));
	}
}
