package com.tactfactory.monprojetsb.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id 
	@GeneratedValue
	Long id ; 
	
	String firstname ; 
	String lastname ; 
	@OneToMany
	List<Product> products ; 
}
