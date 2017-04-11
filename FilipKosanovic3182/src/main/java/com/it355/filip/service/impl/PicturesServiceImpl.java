/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.filip.service.impl;

import com.it355.filip.dao.PicturesDao;
import com.it355.filip.model.Pictures;
import com.it355.filip.service.PicturesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Filip Wolve
 */
public class PicturesServiceImpl implements PicturesService{

    @Autowired
    PicturesDao picturesDao;
    
    @Override
    public int getCount() {
        return picturesDao.getCount();
    }

    @Override
    public List<Pictures> getPicturesByID(int id) {
        return picturesDao.getPicturesByID(id);
    }

    @Override
    public List<Pictures> getAllPictures() {
        return picturesDao.getAllPictures();
    }

    @Override
    public boolean addPicture(Pictures picture) {
        return picturesDao.addPicture(picture);
    }

    @Override
    public boolean removePicture(int pictureID) {
        return picturesDao.removePicture(pictureID);
    }

    @Override
    public boolean updatePicture(Pictures picture) {
        return picturesDao.updatePicture(picture);
    }
    
}
