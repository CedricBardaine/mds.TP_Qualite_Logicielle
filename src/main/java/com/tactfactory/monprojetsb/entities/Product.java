package com.tactfactory.monprojetsb.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
//pas besoin de l'annotation @Table ? car ca creer bien les tables dans la bdd
public class Product implements Serializable {
	
	@Id 
	@GeneratedValue
	private Long id ; 
	
	private String name ; 
	
	private float price ;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	} 
	
	
}
