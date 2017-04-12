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
@Table(name="brand")
@SuppressWarnings("serial")
public class Brand implements Serializable{
    @Id
    @Column(name="brand_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    private int brandID;
    private String name;
    private String country;
    private String Description;
    private String picture;

    public void setPicture(String picture) {
        this.picture = picture;
    }

    
    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getBrandID() {
        return brandID;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getDescription() {
        return Description;
    }

    public String getPicture() {
        return picture;
    }

    @Override
    public String toString() {
        return "Brand{" + "brandID=" + brandID + ", name=" + name + ", country=" + country + ", Description=" + Description + ", picture=" + picture + '}';
    }
    
    

    
    
    
}
