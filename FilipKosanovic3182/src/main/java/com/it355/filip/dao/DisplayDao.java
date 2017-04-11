/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.filip.dao;

import com.it355.filip.model.Display;
import java.util.List;

/**
 *
 * @author Filip Wolve
 */
public interface DisplayDao {
    public int getCount();
    public List<Display> getDisplayByID(int id);
    public List<Display> getAllDisplays();
    public boolean addDisplay(Display display);
    public boolean removeDisplay(String name);
    public boolean updateDisplay(Display display);
}
