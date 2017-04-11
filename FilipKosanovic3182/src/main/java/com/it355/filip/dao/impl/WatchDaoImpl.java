/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.filip.dao.impl;

import com.it355.filip.dao.WatchDao;
import com.it355.filip.mapper.WatchMapper;
import com.it355.filip.model.Watch;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Filip Wolve
 */
public class WatchDaoImpl implements WatchDao{

    private JdbcTemplate jdbcTemplate; 
    @SuppressWarnings("unused") 
    private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource; 
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Override
    public int getCount() {
        String sql = "SELECT COUNT(*) FROM watch"; 
        int count = jdbcTemplate.queryForObject(sql, Integer.class); 
        return count; 
    }

    @Override
    public List<Watch> getWatchByID(int id) {
        String sql= "SELECT * FROM watch WHERE watch_ID =" + id; 
        List<Watch> watches= jdbcTemplate.query(sql, new WatchMapper()); 
        return watches;
    }

    @Override
    public List<Watch> getAllWatches() {
        String sql= "SELECT * FROM watch"; 
        List<Watch> watches= jdbcTemplate.query(sql, new WatchMapper()); 
        return watches;
    }

    @Override
    public boolean addWatch(Watch watch) {
        String sql = "INSERT INTO watch " + "(watch_ID, brand_ID, gender, case, display_ID, strap_ID, price, amount, model, model_year, description, waterproof, special_offer) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
        jdbcTemplate.update(sql, new Object[] {
            watch.getWatchID(),
            watch.getBrandID(),
            watch.getGender(),
            watch.getWatchCase(),
            watch.getDisplayID(),
            watch.getStrapID(),
            watch.getPrice(),
            watch.getAmount(),
            watch.getModel(),
            watch.getModelYear(),
            watch.getDescription(),
            watch.getWaterproof(),
            watch.getSpecialOffer()
        });
        return true;
    }

    @Override
    public boolean removeWatch(String model) {
        String sql = "DELETE FROM watch WHERE model= " + model;
        jdbcTemplate.update(sql);
        return true;
    }

    @Override
    public boolean updateWatch(Watch watch) {
        String sql = "UPDATE watch set brand_ID =?, gender =?, case =?, display_ID=?, strap_ID =?, price =?, amount =?, model =?, model_year =?, description =?, waterproof =?, special_offer =? where watch_ID = ?"; 
        jdbcTemplate.update(sql, new Object[] {
            watch.getBrandID(),
            watch.getGender(),
            watch.getWatchCase(),
            watch.getDisplayID(),
            watch.getStrapID(),
            watch.getPrice(),
            watch.getAmount(),
            watch.getModel(),
            watch.getModelYear(),
            watch.getDescription(),
            watch.getWaterproof(),
            watch.getSpecialOffer(),
            watch.getWatchID()
        });
        return true; 
    }

    @Override
    public List<Watch> getWatchesOnOffer() {
        String sql= "SELECT * FROM watch WHERE special_offer = 1"; 
        List<Watch> watches= jdbcTemplate.query(sql, new WatchMapper()); 
        return watches;
    }

    @Override
    public List<Watch> getWatchesWithBrand(int brandID) {        
        String sql= "SELECT * FROM watch WHERE brand_ID = " + brandID; 
        List<Watch> watches= jdbcTemplate.query(sql, new WatchMapper()); 
        return watches;
    }

    @Override
    public List<Watch> getWatchesWithGender(String gender) {
        String sql= "SELECT * FROM watch WHERE gender = " + gender; 
        List<Watch> watches= jdbcTemplate.query(sql, new WatchMapper()); 
        return watches;
    }

    @Override
    public List<Watch> getWatchesWithDisplay(int displayID) {
        String sql= "SELECT * FROM watch WHERE display_ID = " + displayID; 
        List<Watch> watches= jdbcTemplate.query(sql, new WatchMapper()); 
        return watches;
    }

    @Override
    public List<Watch> getWatchesWithStrap(int strapID) {
        String sql= "SELECT * FROM watch WHERE strap_ID = " + strapID; 
        List<Watch> watches= jdbcTemplate.query(sql, new WatchMapper()); 
        return watches;
    }

    @Override
    public List<Watch> getWatchesWithWaterproof() {
        String sql= "SELECT * FROM watch WHERE waterproof = 1"; 
        List<Watch> watches= jdbcTemplate.query(sql, new WatchMapper()); 
        return watches;
    }
    
}
