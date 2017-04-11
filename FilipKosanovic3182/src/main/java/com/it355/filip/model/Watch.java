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
public class Watch implements Serializable{
    private int watch_ID;
    private int brand_ID;
    private String gender;
    private String watchCase;
    private int display_ID;
    private int strap_ID;
    private double price;
    private int amount;
    private String model;
    private int modelYear;
    private String description;
    private boolean waterproof;
    private boolean specialOffer;

    public int getWatchID() {
        return watch_ID;
    }

    public int getBrandID() {
        return brand_ID;
    }

    public String getGender() {
        return gender;
    }

    public String getWatchCase() {
        return watchCase;
    }

    public int getDisplayID() {
        return display_ID;
    }

    public int getStrapID() {
        return strap_ID;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public String getModel() {
        return model;
    }

    public int getModelYear() {
        return modelYear;
    }

    public String getDescription() {
        return description;
    }

    public boolean getWaterproof() {
        return waterproof;
    }

    public boolean getSpecialOffer() {
        return specialOffer;
    }

    public void setWatchID(int watchID) {
        this.watch_ID = watch_ID;
    }

    public void setBrandID(int brandID) {
        this.brand_ID = brandID;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setWatchCase(String watchCase) {
        this.watchCase = watchCase;
    }

    public void setDisplayID(int displayID) {
        this.display_ID = displayID;
    }

    public void setStrapID(int strapID) {
        this.strap_ID = strapID;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWaterproof(boolean waterproof) {
        this.waterproof = waterproof;
    }

    public void setSpecialOffer(boolean specialOffer) {
        this.specialOffer = specialOffer;
    }
    
    @Override 
    public String toString() { 
        return "Watch [watchID=" + watch_ID + ", brandID=" + brand_ID + ", gender=" + gender + ", watchCase="+ watchCase + ", displayID=" 
                + display_ID + ", strapID" + strap_ID + ", prica=" + price+ ",  amount=" + amount +", model=" +model + ", modelYear=" + modelYear +
                ", description=" + description + ", waterproof=" + waterproof + ", specialOffer=" + specialOffer + "]"; 
    }
}