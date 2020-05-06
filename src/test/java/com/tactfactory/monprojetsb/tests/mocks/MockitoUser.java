package com.tactfactory.monprojetsb.tests.mocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.tactfactory.monprojetsb.dao.UserDAO;
import com.tactfactory.monprojetsb.entities.Product;
import com.tactfactory.monprojetsb.entities.User;

public class MockitoUser {

	//	protected final UserDAO theUserRepo ; 
	//	
	//	private Product product1 = new Product("Product1", (float) 5.5) ; 
	//	private Product product2 = new Product("Product2", (float) 7.7) ; 
	//	private List<Product> someProducts = new ArrayList<Product>() ;
	//	
	//	private User user1 = new User("Jean Michel", "Doudoux"); 
	//	private User user2 = new User("Jean", "Jacques"); 
	//	private User user3 = new User("Clement", "Le Saint"); 
	//	private User user4 = new User("Henry", "Henryyyyy"); 
	//	private User user5 = new User("Jesus", "Christ", someProducts );
	//	
	//	
	//	public MockitoUser(UserDAO userRepo) {
	//		this.theUserRepo = userRepo ; 
	////		super();
	//		this.someProducts.add(product1);
	//		this.someProducts.add(product2);
	//		
	//		
	//	} 
	//	
	//	public void init() {
	////		Mockito.when(objetAMocker.fonction(params ...)).thenReturn(this.result);
	////		Mockito.when(objetAMocker.fonction(params ...)).thenAnswer(new Answer<objetAEnvoyer>() {
	////		 @Override
	////		 public objetAEnvoyer answer(InvocationOnMock invocation) throws Throwable {
	////		 User user = invocation.getArgument(0);
	////		 user.setId(1L);
	////		 return MaClass.this.result ;
	////		 }
	////		 });
	//	}
	//	

	protected final UserDAO repository;

	public User entity;

	public User resultEntity;

	public Optional<User> resultOptional;

	public MockitoUser(UserDAO repository) {
		this.repository = repository;
		this.entity = new User("fn1","ln1");
	}

	public void intialize() {
		// this.configure();

		this.resultEntity = new User();
		this.resultEntity.setId(this.entity.getId());
		this.resultEntity.setFirstname(this.entity.getFirstname());
		this.resultEntity.setLastname(this.entity.getLastname());

		this.resultEntity.setId(1L);
		this.resultOptional = Optional.of(this.resultEntity);

		Mockito.when(this.repository.findById(1L)).thenReturn(this.resultOptional);

		Mockito.when(this.repository.findAll((Pageable) ArgumentMatchers.any()))
		.thenReturn(new PageImpl<>(Arrays.asList(this.resultEntity)));

		Mockito.when(this.repository.save(ArgumentMatchers.any())).thenAnswer(new Answer<User>() {

			@Override
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = invocation.getArgument(0);
				user.setId(1L);
				return MockitoUser.this.resultEntity;
			}
		});
		
//		Mockito.when(this.repository.count()).thenReturn((long) 5);
	}


}
