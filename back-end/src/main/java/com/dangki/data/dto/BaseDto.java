package com.dangki.data.dto;

import java.util.Date;

public class BaseDto {
    protected Long id;
    protected String creator;
    protected Date createdTime;
    protected String modifier;
    protected Date modifiedTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreator() {
        return creator;
    }


    public Date getCreatedTime() {
        return createdTime;
    }


    public String getModifier() {
        return modifier;
    }


    public Date getModifiedTime() {
        return modifiedTime;
    }

}
