package org.sang.bean;

import java.sql.Timestamp;

/**
 * Created by sang on 2017/12/19.
 */
public class Category {
    private Long id;
    private String cateName;
    private Timestamp date;
    private int status;

    public Category() {
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public int getStatus(){return status;}

    public  void  setStatus(int status){this.status=status;}
}
