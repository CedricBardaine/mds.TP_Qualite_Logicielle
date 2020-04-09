package com.tactfactory.monprojetsb.monprojetsb.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
	@Id 
	@GeneratedValue
	Long id ; 
	
	String name ; 
	float price ; 
}
