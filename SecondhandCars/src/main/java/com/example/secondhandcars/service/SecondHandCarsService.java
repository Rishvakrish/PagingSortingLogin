package com.example.secondhandcars.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.secondhandcars.model.SecondHandCars;
import com.example.secondhandcars.repository.SecondHandCarsRepository;

@Service

public class SecondHandCarsService {
	@Autowired
	SecondHandCarsRepository Car;
	
	//Get
	public List<SecondHandCars> GetCarDetails(){
		return Car.findAll();
	}
	//Save
	public SecondHandCars SaveCarDetails(SecondHandCars n) {
		return Car.save(n);
	}
	//Update
	public SecondHandCars UpdateCarDetailsById(SecondHandCars h)
	{
		return Car.save(h);
	}
	public SecondHandCars PutCar(SecondHandCars s,int sno)
	{
		Optional<SecondHandCars> optional = Car.findById(sno);
		SecondHandCars obj = null;
		if(optional.isPresent())
		{
			obj = optional.get();
			Car.save(s);
		}
		return obj;
	}
	//Delete
	public void DeleteCarDetailsById(int f)
	{
		Car.deleteById(f);
	}
	//FindById
	public SecondHandCars FindCarDetailsById(int y)
	{
		return Car.findById(y).orElse(null);
	}
	
	
	
	
	
	
	
	
	//Sort - ASC
	public List<SecondHandCars> SortByCarDetailsAsc(String field)
	{
		return Car.findAll(Sort.by(field));
	}
	//Sort - DESC
	public List<SecondHandCars> SortByCarDetailsDesc(String field)
	{
		return Car.findAll(Sort.by(Direction.DESC,field));
	}
	//Pagination - list
	public List<SecondHandCars> ListOfCars(int offset,int pageSize)
	{
		Pageable paging = PageRequest.of(offset,pageSize);
		Page<SecondHandCars> ri = Car.findAll(paging);
		List<SecondHandCars> ro = ri.getContent();
		return ro;
	}
	//Pagination - page
	public Page<SecondHandCars> pagingCars(int offset,int pageSize)
	{
		Pageable paging = PageRequest.of(offset,pageSize);
		Page<SecondHandCars> ri = Car.findAll(paging);
		return ri;
	}
	//Pagination - list - sorting
	public List<SecondHandCars> SortListCars(int offset,int pageSize,String field)
	{
		Pageable paging = PageRequest.of(offset,pageSize).withSort(Sort.by(field));
		Page<SecondHandCars> ri = Car.findAll(paging);
		List<SecondHandCars> ro = ri.getContent();
		return ro;
	}
	//Pagination - page - sorting
	public Page<SecondHandCars> SortPageCars(int offset,int pageSize,String field)
	{
		Pageable paging = PageRequest.of(offset,pageSize).withSort(Sort.by(field));
		Page<SecondHandCars> ri = Car.findAll(paging);
		return ri;
	}
	//BrandStartingWith
	public List<SecondHandCars> fetchCarsByBrandPrefix(String prefix)
	{
		return Car.findByBrandStartingWith(prefix);
	}
	//BrandEndingWith
	public List<SecondHandCars> fetchCarsByBrandSuffix(String suffix)
	{
		return Car.findByBrandEndingWith(suffix);
	}
	//SearchByModel
	public List<SecondHandCars> fetchCarByModel(String model)
	{
		return Car.findByModel(model);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//PositionalParameter
	public List<SecondHandCars> getPositionalParameter(String brand,String colour)
	{
		return Car.fetchPositionalParameter(brand,colour);
	}
	//NamedParameter
	public List<SecondHandCars> getNamedParameter(String brand)
	{
		return Car.fetchNamedParameter(brand);
	}
	//DMLDeleteQuery
	public List<SecondHandCars> deleteByModel(String model)
	{
		return Car.deleteCarByModel(model);
	}
}
