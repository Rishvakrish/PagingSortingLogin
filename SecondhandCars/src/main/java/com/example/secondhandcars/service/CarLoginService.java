package com.example.secondhandcars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.secondhandcars.model.CarLogin;
import com.example.secondhandcars.repository.CarLoginRepository;
@Service
public class CarLoginService {
	@Autowired
	CarLoginRepository ab;
public CarLogin saveCar(CarLogin u)
{
	return ab.save(u);
}
public String validateCar(String username,String password)
{
	String result="";
	CarLogin u=ab.findByUsername(username);
	if(u==null)
	{
		result="Invalid user";	
	}
		else
		{
			if(u.getPassword().equals(password))
			{
				result="Login success";
			}
			else
			{
				result="Login failed";
			}
		}
	

	return result;
	}
}
