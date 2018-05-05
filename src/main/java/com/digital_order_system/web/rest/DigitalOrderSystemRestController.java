package com.digital_order_system.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital_order_system.domain.Category;
import com.digital_order_system.domain.Food;
import com.digital_order_system.service.CategoryService;
import com.digital_order_system.service.FoodService;

@RestController
@RequestMapping(value="/rest/dos")
public class DigitalOrderSystemRestController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private FoodService foodService;
	
	@GetMapping(value="/category/all")
	public List<Category> getAll(){
		return categoryService.getAll();
	}
	
	@GetMapping(value="/food/all")
	public List<Food> getAllFoods(){
		return foodService.getAll();
	}
	
	@GetMapping(value="/food/category/{id}")
	public List<Food> getFoodsByCategory(@PathVariable("id") Integer id){
		return foodService.getFoodByCategory(id);
	}
}
