package com.example.secondhandcars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.secondhandcars.model.CarLogin;

@Repository 
public interface CarLoginRepository extends JpaRepository<CarLogin,Integer>{
	CarLogin findByUsername(String username);

}
