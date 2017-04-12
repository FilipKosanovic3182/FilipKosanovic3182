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
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Filip Wolve
 */
@Service
public class WatchServiceImpl implements WatchService{
    private WatchDao watchDao;
    public void setWatchDAO(WatchDao watchDao) {
        this.watchDao = watchDao;
    }
    /*@Autowired
    WatchDao watchDao;*/
    
    @Override
    @Transactional
    public int getCount() {
        return this.watchDao.getCount();
    }

    @Override
    @Transactional
    public Watch getWatchByID(int id) {
        return this.watchDao.getWatchByID(id);
    }

    @Override
    @Transactional
    public List<Watch> getAllWatches() {
        return this.watchDao.getAllWatches();
    }

    @Override
    @Transactional
    public boolean addWatch(Watch watch) {
        return this.watchDao.addWatch(watch);
    }

    @Override
    @Transactional
    public boolean removeWatch(int id) {
        return this.watchDao.removeWatch(id);
    }

    @Override
    @Transactional
    public boolean updateWatch(Watch watch) {
        return this.watchDao.updateWatch(watch);
    }

    @Override
    @Transactional
    public List<Watch> getWatchesOnOffer() {
        return this.watchDao.getWatchesOnOffer();
    }

    @Override
    @Transactional
    public List<Watch> getWatchesWithBrand(int brandID) {
        return this.watchDao.getWatchesWithBrand(brandID);
    }

    @Override
    @Transactional
    public List<Watch> getWatchesWithGender(String gender) {
        return this.watchDao.getWatchesWithGender(gender);
    }

    @Override
    @Transactional
    public List<Watch> getWatchesWithDisplay(int displayID) {
        return this.watchDao.getWatchesWithDisplay(displayID);
    }

    @Override
    @Transactional
    public List<Watch> getWatchesWithStrap(int strapID) {
        return this.watchDao.getWatchesWithStrap(strapID);
    }

    @Override
    @Transactional
    public List<Watch> getWatchesWithWaterproof() {
        return this.watchDao.getWatchesWithWaterproof();
    }
    
}
