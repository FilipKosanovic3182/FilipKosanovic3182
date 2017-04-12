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
@Table(name="pictures")
@SuppressWarnings("serial") 
public class Pictures implements Serializable{
    @Id
    @Column(name="picture_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int picture_ID;
    private int watch_ID;
    private String path;
    private String title;
    private String description;

    public int getPicture_ID() {
        return picture_ID;
    }

    public int getWatch_ID() {
        return watch_ID;
    }

    public String getPath() {
        return path;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setPicture_ID(int picture_ID) {
        this.picture_ID = picture_ID;
    }

    public void setWatch_ID(int watch_ID) {
        this.watch_ID = watch_ID;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Pictures[" + "picture_ID=" + picture_ID + ", watch_ID=" + watch_ID + ", path=" + path + ", title=" + title + ", description=" + description + ']';
    }
    
    
}
