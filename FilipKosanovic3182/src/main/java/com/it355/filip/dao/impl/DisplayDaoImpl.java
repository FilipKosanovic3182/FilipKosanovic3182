/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.filip.dao.impl;

import com.it355.filip.dao.DisplayDao;
import com.it355.filip.mapper.DisplayMapper;
import com.it355.filip.model.Display;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Filip Wolve
 */
public class DisplayDaoImpl implements DisplayDao{

    private JdbcTemplate jdbcTemplate; 
    @SuppressWarnings("unused") 
    private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource; 
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Override
    public int getCount() {
        String sql = "SELECT COUNT(*) FROM display"; 
        int count = jdbcTemplate.queryForObject(sql, Integer.class); 
        return count;     
    }

    @Override
    public List<Display> getDisplayByID(int id) {
        String sql= "SELECT * FROM display WHERE brand_ID =" + id; 
        List<Display> displays= jdbcTemplate.query(sql, new DisplayMapper()); 
        return displays;    
    }

    @Override
    public List<Display> getAllDisplays() {
        String sql= "SELECT * FROM display"; 
        List<Display> displays= jdbcTemplate.query(sql, new DisplayMapper()); 
        return displays;    
    }

    @Override
    public boolean addDisplay(Display display) {
        String sql = "INSERT INTO display " + "(display_ID, name, description, picture) VALUES ( ?, ?, ?, ?)"; 
        jdbcTemplate.update(sql, new Object[] {
            display.getDisplayID(), 
            display.getName(), 
            display.getDescription(),
            display.getPicture()
        });
        return true; 
    }

    @Override
    public boolean removeDisplay(String name) {
        String sql = "DELETE FROM display WHERE name= " + name;
        jdbcTemplate.update(sql);
        return true;
    }

    @Override
    public boolean updateDisplay(Display display) {
        String sql = "UPDATE display set name = ?, description =?, picture =? where display_ID = ?";
        jdbcTemplate.update(sql, new Object[] {
            display.getName(), 
            display.getDescription(),
            display.getPicture(),
            display.getDisplayID()
        });
        return true; 
    }
    
}
