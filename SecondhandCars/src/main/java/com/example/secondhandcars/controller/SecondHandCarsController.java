package com.example.secondhandcars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.secondhandcars.model.SecondHandCars;
import com.example.secondhandcars.service.SecondHandCarsService;
@RestController
public class SecondHandCarsController {
	@Autowired
	SecondHandCarsService re;
	
	//Get
    //127.0.0.1:8080/get
    @GetMapping(value="/get")
    public List<SecondHandCars> getDetails(){
   	 return re.GetCarDetails();
    }
    //Save
    //127.0.0.1:8080/save
    @PostMapping(value="/save")
    public String saveDetails(@RequestBody SecondHandCars a)
    {
    	re.SaveCarDetails(a);
    	return "saved";
    }
    //Update
    //127.0.0.1:8080/update
    @PutMapping(value="/update")
    public String updateById(@RequestBody SecondHandCars b)
    {
    	re.UpdateCarDetailsById(b);
    	return "updated";
    }
    //UpdateDetails
    //127.0.0.1:8080/updateDetails
    @PutMapping(value="/updateDetails")
    public String PutCars(@RequestBody SecondHandCars d,@PathVariable int sno)
    {
    	re.PutCar(d,sno);
    	return "updated";
    }
    //Delete
    //127.0.0.1:8080/delete/5
    @DeleteMapping(value="/delete/{id}")
    public String deleteById(@PathVariable int id)
    {
    	re.DeleteCarDetailsById(id);
    	return "deleted";
    }
    //Find
    //127.0.0.1:8080/find/4
    @GetMapping(value="/find/{c}")
    public SecondHandCars findById(@PathVariable int c)
    {
   	 return re.FindCarDetailsById(c);
    }
    
    
    
    
    
    
    
    
    
    //SortAsc
    //127.0.0.1:8080/sortCar/brand
    @GetMapping("/sortCar/{field}")
    public List<SecondHandCars> sortCarAsc(@PathVariable String field)
    {
   	 return re.SortByCarDetailsAsc(field);
    }
    //SortDesc
    //127.0.0.1:8080/sortCarDesc/colour
    @GetMapping("/sortCarDesc/{field}")
    public List<SecondHandCars> sortCarDesc(@PathVariable String field)
    {
   	 return re.SortByCarDetailsDesc(field);
    }
    //List - paging
    //127.0.0.1:8080/listpagingcar/0/3
    @GetMapping("/listpagingcar/{offset}/{pageSize}")
    public List<SecondHandCars> listCars(@PathVariable int offset,@PathVariable int pageSize)
    {
    	return re.ListOfCars(offset,pageSize);
    }
    //Paging
    //127.0.0.1:8080/pagingcar/0/2
    @GetMapping("/pagingcar/{offset}/{pageSize}")
    public Page<SecondHandCars> pagingCars(@PathVariable int offset,@PathVariable int pageSize)
    {
    	return re.pagingCars(offset,pageSize);
    }
    //Sorting and paging - list
    //127.0.0.1:8080/sortlistofcar/0/3/model
    @GetMapping("/sortlistofcar/{offset}/{pageSize}/{field}")
    public List<SecondHandCars> sortListCar(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field)
    {
    	return re.SortListCars(offset,pageSize,field);
    }
    //Sort and paging - paging
    //127.0.0.1:8080/sortpagingofcar/0/2/colour
    @GetMapping("/sortpagingofcar/{offset}/{pageSize}/{field}")
    public Page<SecondHandCars> sortPagingOfCar(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field)
    {
    	return re.SortPageCars(offset,pageSize,field);
    }
    //Fetch Brand Starting With Prefix
    //127.0.0.1:8080/fetchCarByBrandPrefix?prefix=m
    @GetMapping("/fetchCarByBrandPrefix")
    public List<SecondHandCars> fetchCarByBrandPrefix(@RequestParam String prefix)
    {
    	return re.fetchCarsByBrandPrefix(prefix);
    }
    //Fetch Brand Ending With Suffix
    //127.0.0.1:8080/fetchCarByBrandSuffix?suffix=n
    @GetMapping("/fetchCarByBrandSuffix")
    public List<SecondHandCars> fetchCarByBrandSufffix(@RequestParam String suffix)
    {
    	return re.fetchCarsByBrandSuffix(suffix);
    }
    //Fetch By Model
    //127.0.0.1:8080/fetchCarByModel?model=polo
    @GetMapping("/fetchCarByModel")
    public List<SecondHandCars> fetchCarByModel(@RequestParam String model)
    {
    	return re.fetchCarByModel(model);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    //Positional Parameter
    //127.0.0.1:8080/getPostionalParameter/tata/black
    @GetMapping("/getPostionalParameter/{brand}/{colour}")
    public List<SecondHandCars> getPositionalParameter(@PathVariable String brand,@PathVariable String colour)
    {
    	return re.getPositionalParameter(brand,colour);
    }
    //Named Parameter
    @GetMapping("/getNamedParameter/{brand}")
    public List<SecondHandCars> getNamedParameter(@PathVariable String brand)
    {
    	return re.getNamedParameter(brand);
    }
    //DML Delete Query
    @GetMapping("/deleteByModel/{model}")
    public List<SecondHandCars> deleteByModel(@PathVariable String model)
    {
    	return re.deleteByModel(model);
    }
}
