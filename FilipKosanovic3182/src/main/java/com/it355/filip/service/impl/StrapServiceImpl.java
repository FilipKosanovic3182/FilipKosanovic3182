/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.filip.service.impl;

import com.it355.filip.dao.StrapDao;
import com.it355.filip.model.Strap;
import com.it355.filip.service.StrapService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Filip Wolve
 */
@Service
public class StrapServiceImpl implements StrapService{

    private StrapDao strapDao;
    
    public void setStrapDao(StrapDao strapDao) {
        this.strapDao = strapDao;
    }
    /*@Autowired
    StrapDao strapDao;*/
    
    @Override
    @Transactional
    public int getCount() {
        return this.strapDao.getCount();
    }

    @Override
    @Transactional
    public Strap getStrapByID(int id) {
        return this.strapDao.getStrapByID(id);
    }

    @Override
    @Transactional
    public List<Strap> getAllStraps() {
        return this.strapDao.getAllStraps();
    }

    @Override
    @Transactional
    public boolean addStrap(Strap strap) {
        return this.strapDao.addStrap(strap);
    }

    @Override
    @Transactional
    public boolean removeStrap(int id) {
        return this.strapDao.removeStrap(id);
    }

    @Override
    @Transactional
    public boolean updateStrap(Strap strap) {
        return this.strapDao.updateStrap(strap);
    }
    
}
