/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.filip.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Filip Wolve
 */
@Entity
@Table(name="display")
@SuppressWarnings("serial")
public class Display implements Serializable{
    @Id
    @Column(name="display_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
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
