/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.filip.service;

import com.it355.filip.model.Strap;
import java.util.List;

/**
 *
 * @author Filip Wolve
 */
public interface StrapService {
    public int getCount();
    public Strap getStrapByID(int id);
    public List<Strap> getAllStraps();
    public boolean addStrap(Strap strap);
    public boolean removeStrap(int id);
    public boolean updateStrap(Strap strap);
}
