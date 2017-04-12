/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.filip.service;

import com.it355.filip.model.Watch;
import java.util.List;

/**
 *
 * @author Filip Wolve
 */
public interface WatchService {
    public int getCount();
    public Watch getWatchByID(int id);
    public List<Watch> getAllWatches();
    public boolean addWatch(Watch watch);
    public boolean removeWatch(int id);
    public boolean updateWatch(Watch watch);
    public List<Watch> getWatchesOnOffer();
    public List<Watch> getWatchesWithBrand(int brandID);
    public List<Watch> getWatchesWithGender(String gender);
    public List<Watch> getWatchesWithDisplay(int displayID);
    public List<Watch> getWatchesWithStrap(int strapID);
    public List<Watch> getWatchesWithWaterproof();
}
