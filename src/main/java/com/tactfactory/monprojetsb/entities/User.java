package com.tactfactory.monprojetsb.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
// pas besoin de l'annotation @Table ? car ca creer bien les tables dans la bdd
public class User implements Serializable {
	
	@Id 
	@GeneratedValue
	private Long id ; 
	
	private String firstname ;
	
	private String lastname ; 
	
	@OneToMany
	private List<Product> products ;
	
	
	public User(String firstname, String lastname, List<Product> products) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.products = products;
	}
	public User(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}
	public User() {	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	} 
	
	
	
}
