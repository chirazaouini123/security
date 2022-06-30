package com.bezkoder.springjwt.models;

import javax.persistence.*;

@Entity
@Table(name = "Priorities")


public class PriorityModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long priority_id;
    private  String title;

    public PriorityModel() {
    }

    public PriorityModel(Long priority_id, String title) {
        this.priority_id = priority_id;
        this.title = title;
    }

    public Long getPriority_id() {
        return priority_id;
    }

    public void setPriority_id(Long priority_id) {
        this.priority_id = priority_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
