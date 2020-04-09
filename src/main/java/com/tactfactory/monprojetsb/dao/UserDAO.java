package com.tactfactory.monprojetsb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tactfactory.monprojetsb.entities.User;

public interface UserDAO extends JpaRepository<User, Long>{
	
}
