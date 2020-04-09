package com.tactfactory.monprojetsb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tactfactory.monprojetsb.entities.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, Long> {

}
