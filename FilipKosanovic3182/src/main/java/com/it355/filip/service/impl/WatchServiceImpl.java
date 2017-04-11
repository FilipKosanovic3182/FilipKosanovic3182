/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.filip.service.impl;

import com.it355.filip.dao.WatchDao;
import com.it355.filip.model.Watch;
import com.it355.filip.service.WatchService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Filip Wolve
 */
public class WatchServiceImpl implements WatchService{

    @Autowired
    WatchDao watchDao;
    
    @Override
    public int getCount() {
        return watchDao.getCount();
    }

    @Override
    public List<Watch> getWatchByID(int id) {
        return watchDao.getWatchByID(id);
    }

    @Override
    public List<Watch> getAllWatches() {
        return watchDao.getAllWatches();
    }

    @Override
    public boolean addWatch(Watch watch) {
        return watchDao.addWatch(watch);
    }

    @Override
    public boolean removeWatch(String name) {
        return watchDao.removeWatch(name);
    }

    @Override
    public boolean updateWatch(Watch watch) {
        return watchDao.updateWatch(watch);
    }

    @Override
    public List<Watch> getWatchesOnOffer() {
        return watchDao.getWatchesOnOffer();
    }

    @Override
    public List<Watch> getWatchesWithBrand(int brandID) {
        return watchDao.getWatchesWithBrand(brandID);
    }

    @Override
    public List<Watch> getWatchesWithGender(String gender) {
        return watchDao.getWatchesWithGender(gender);
    }

    @Override
    public List<Watch> getWatchesWithDisplay(int displayID) {
        return watchDao.getWatchesWithDisplay(displayID);
    }

    @Override
    public List<Watch> getWatchesWithStrap(int strapID) {
        return watchDao.getWatchesWithStrap(strapID);
    }

    @Override
    public List<Watch> getWatchesWithWaterproof() {
        return watchDao.getWatchesWithWaterproof();
    }
    
}
