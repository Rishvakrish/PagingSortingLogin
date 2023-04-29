package com.example.secondhandcars.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.secondhandcars.model.SecondHandCars;

public interface SecondHandCarsRepository extends JpaRepository<SecondHandCars,Integer>{
		
		public List<SecondHandCars>findByBrandStartingWith(String prefix);
		public List<SecondHandCars>findByBrandEndingWith(String suffix);
		public List<SecondHandCars>findByModel(String model);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//positional parameter
		@Query("select u from SecondHandCars u where u.brand=?1 and u.colour=?2")
		public List<SecondHandCars> fetchPositionalParameter(String brand,String colour);
		
		//named parameter
			@Query("select u from SecondHandCars u where u.brand=?1")
			public List<SecondHandCars> fetchNamedParameter(String brand);	
			
		//DML Delete Query
			@Modifying
			@Query("select u from SecondHandCars u where u.model=?1")
			public List<SecondHandCars> deleteCarByModel(String model);
}
