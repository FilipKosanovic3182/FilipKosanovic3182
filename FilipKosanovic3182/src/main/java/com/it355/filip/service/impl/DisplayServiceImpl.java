/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.filip.service.impl;

import com.it355.filip.dao.DisplayDao;
import com.it355.filip.model.Display;
import com.it355.filip.service.DisplayService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Filip Wolve
 */
@Service
public class DisplayServiceImpl implements DisplayService{

    private DisplayDao displayDao;

    public void setDisplayDAO(DisplayDao displayDao) {
        this.displayDao = displayDao;
    }
    /*@Autowired
    DisplayDao displayDao;*/
    
    @Override
    @Transactional
    public int getCount() {
        return this.displayDao.getCount();
    }

    @Override
    @Transactional
    public Display getDisplayByID(int id) {
        return this.displayDao.getDisplayByID(id);
    }

    @Override
    @Transactional
    public List<Display> getAllDisplays() {
        return this.displayDao.getAllDisplays();
    }

    @Override
    @Transactional
    public boolean addDisplay(Display display) {
        return this.displayDao.addDisplay(display);
    }

    @Override
    @Transactional
    public boolean removeDisplay(int id) {
        return this.displayDao.removeDisplay(id);
    }

    @Override
    @Transactional
    public boolean updateDisplay(Display display) {
        return this.displayDao.updateDisplay(display);
    }
    
}
