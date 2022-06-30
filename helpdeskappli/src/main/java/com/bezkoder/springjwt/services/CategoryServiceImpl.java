package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.Exceptions.ResourcesNotFoundException;
import com.bezkoder.springjwt.models.CategoryModel;
import com.bezkoder.springjwt.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements  CategoryServiceInterface {
    private CategoryRepository categoryRepository;
    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryModel> findAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryModel AddCategory(CategoryModel categoryModel) {
        return categoryRepository.save(categoryModel);
    }

    @Override
    public CategoryModel findCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(()-> new ResourcesNotFoundException("category doesn't exist with id:"+ id));
    }

    @Override
    public CategoryModel updateCategory(Long id, CategoryModel categoryDetails) {
        CategoryModel category=findCategoryById(id);
        category.setTitle(categoryDetails.getTitle());
        return  categoryRepository.save(category);
    }

    @Override
    public Map<String, Boolean> deleteCategory(Long id) {
        CategoryModel category=findCategoryById(id);
        categoryRepository.delete(category);
        Map<String,Boolean> response=new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }
}
