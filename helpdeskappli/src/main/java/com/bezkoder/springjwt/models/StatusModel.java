package com.bezkoder.springjwt.models;

import javax.persistence.*;

@Entity
@Table(name="Status")
public class StatusModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long status_id;
    private String title;


    public StatusModel() {
    }

    public StatusModel(Long status_id, String title) {
        this.status_id = status_id;
        this.title = title;
    }

    public Long getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Long status_id) {
        this.status_id = status_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
