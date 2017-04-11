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
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Filip Wolve
 */
public class DisplayServiceImpl implements DisplayService{

    @Autowired
    DisplayDao displayDao;
    
    @Override
    public int getCount() {
        return displayDao.getCount();
    }

    @Override
    public List<Display> getDisplayByID(int id) {
        return displayDao.getDisplayByID(id);
    }

    @Override
    public List<Display> getAllDisplays() {
        return displayDao.getAllDisplays();
    }

    @Override
    public boolean addDisplay(Display display) {
        return displayDao.addDisplay(display);
    }

    @Override
    public boolean removeDisplay(String name) {
        return displayDao.removeDisplay(name);
    }

    @Override
    public boolean updateDisplay(Display display) {
        return displayDao.updateDisplay(display);
    }
    
}
