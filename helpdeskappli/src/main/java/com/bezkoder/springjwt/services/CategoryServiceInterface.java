package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.models.CategoryModel;

import java.util.List;
import java.util.Map;

public interface CategoryServiceInterface {
    public List<CategoryModel> findAllCategory();
    public CategoryModel AddCategory(CategoryModel categorymodel);
    public CategoryModel findCategoryById( Long id);
    public CategoryModel updateCategory(Long id,  CategoryModel categoryDetails);
    public Map<String,Boolean> deleteCategory(Long id);
}
