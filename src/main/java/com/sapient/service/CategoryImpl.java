package com.sapient.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.dao.CategoryRepository;
import com.sapient.model.Category;
import com.sapient.model.User;


@Service
public class CategoryImpl {
	@Autowired
	CategoryRepository categoryRepository;
	
	
	public Category getCategoryById(Integer id) {
		return categoryRepository.findById(id).orElseThrow(null);
	}
	
	public Integer addNewCategory(Category category) {
		return categoryRepository.save(category).getCategoryId();
	}
	
//	public boolean isValid(User user) {
//		ArrayList<User> list = categoryRepository.findAllByPassword(user.getPassword(),user.getEmail());
//		if(list.size()!=0)
//		{
//			return true;
//		}
//		return false;
//	}
	
	public String deleteCategory(Category category) {
		try {
			categoryRepository.delete(category);
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
		return "Category Deleted";
	}

	public ArrayList<Category> getAllCategories() {
		return new ArrayList<Category>(categoryRepository.findAll());
	}
	
	public boolean isCategoryExists(Category category)
	{
		ArrayList<Category> categoryList = categoryRepository.findByCategoryName(category.getCategoryName());
		if(!categoryList.isEmpty())
		{
			return true;
		}
		return false;
	}

	public Integer getCategoryByName(Category category) {
		ArrayList<Category> categoryList = categoryRepository.findByCategoryName(category.getCategoryName());
		return categoryList.get(0).getCategoryId();
	}
}
