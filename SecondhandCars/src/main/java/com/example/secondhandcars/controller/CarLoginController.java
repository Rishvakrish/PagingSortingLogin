package com.example.secondhandcars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.secondhandcars.model.CarLogin;
import com.example.secondhandcars.service.CarLoginService;

@RestController
public class CarLoginController {
	@Autowired
	CarLoginService hj;
	@PostMapping("/checkLogin")
		public String validateCar(@RequestBody CarLogin u)
		{
		System.out.println(u.getUsername());
			return hj.validateCar(u.getUsername(),u.getPassword());
		}
	@PostMapping("/add")
	public void CarLogin(@RequestBody CarLogin u)
	{
		hj.saveCar(u);
	}
}
