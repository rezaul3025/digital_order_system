package com.digital_order_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital_order_system.domain.Category;
import com.digital_order_system.repo.CategoryRepository;

@Service
public class CategoryServiceHandler implements CategoryService {

	@Autowired
	private CategoryRepository categoryServiceRepository;
	
	public CategoryServiceHandler() {

	}

	@Override
	public List<Category> getAll() {
		return categoryServiceRepository.findAll();
	}

}
