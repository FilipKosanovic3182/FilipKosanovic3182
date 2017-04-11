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
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Filip Wolve
 */
public class StrapServiceImpl implements StrapService{

    @Autowired
    StrapDao strapDao;
    
    @Override
    public int getCount() {
        return strapDao.getCount();
    }

    @Override
    public List<Strap> getStrapByID(int id) {
        return strapDao.getStrapByID(id);
    }

    @Override
    public List<Strap> getAllStraps() {
        return strapDao.getAllStraps();
    }

    @Override
    public boolean addStrap(Strap strap) {
        return strapDao.addStrap(strap);
    }

    @Override
    public boolean removeStrap(String name) {
        return strapDao.removeStrap(name);
    }

    @Override
    public boolean updateStrap(Strap strap) {
        return strapDao.updateStrap(strap);
    }
    
}
