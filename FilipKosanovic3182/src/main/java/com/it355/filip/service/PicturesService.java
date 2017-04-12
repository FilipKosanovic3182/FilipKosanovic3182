/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.filip.service;

import com.it355.filip.model.Pictures;
import java.util.List;

/**
 *
 * @author Filip Wolve
 */
public interface PicturesService {
    public int getCount();
    public Pictures getPicturesByID(int id);
    public List<Pictures> getAllPictures();
    public boolean addPicture(Pictures picture);
    public boolean removePicture(int pictureID);
    public boolean updatePicture(Pictures picture);
}
