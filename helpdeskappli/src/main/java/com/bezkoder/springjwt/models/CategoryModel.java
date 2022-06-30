package com.bezkoder.springjwt.models;

import javax.persistence.*;

@Entity
@Table(name="Categories")
public class CategoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long category_id;
    private String title;



    public CategoryModel() {
    }

    public CategoryModel(Long category_id, String title) {
        this.category_id = category_id;
        this.title = title;

    }



    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
