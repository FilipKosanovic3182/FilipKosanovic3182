/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.filip.model;

import java.io.Serializable;

/**
 *
 * @author Filip Wolve
 */
@SuppressWarnings("serial")
public class Display implements Serializable{
    private int displayID;
    private String name;
    private String description;
    private String picture;

    public String getPicture() {
        return picture;
    }

    
    public int getDisplayID() {
        return displayID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDisplayID(int displayID) {
        this.displayID = displayID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Display{" + "displayID=" + displayID + ", name=" + name + ", description=" + description + ", picture=" + picture + '}';
    }
    
    

    
    
    
}
