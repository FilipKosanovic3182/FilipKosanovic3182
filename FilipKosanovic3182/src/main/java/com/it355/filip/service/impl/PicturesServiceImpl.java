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
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Filip Wolve
 */
@Service
public class PicturesServiceImpl implements PicturesService{

    private PicturesDao picturesDao;
    public void setPicturesDAO(PicturesDao picturesDao) {
        this.picturesDao = picturesDao;
    }
    
    /*@Autowired
    PicturesDao picturesDao;*/
    
    @Override
    @Transactional
    public int getCount() {
        return this.picturesDao.getCount();
    }

    @Override
    @Transactional
    public Pictures getPicturesByID(int id) {
        return this.picturesDao.getPicturesByID(id);
    }

    @Override
    @Transactional
    public List<Pictures> getAllPictures() {
        return this.picturesDao.getAllPictures();
    }

    @Override
    @Transactional
    public boolean addPicture(Pictures picture) {
        return this.picturesDao.addPicture(picture);
    }

    @Override
    @Transactional
    public boolean removePicture(int pictureID) {
        return this.picturesDao.removePicture(pictureID);
    }

    @Override
    @Transactional
    public boolean updatePicture(Pictures picture) {
        return this.picturesDao.updatePicture(picture);
    }
    
}
