/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.filip.dao.impl;

import com.it355.filip.dao.StrapDao;
import com.it355.filip.mapper.StrapMapper;
import com.it355.filip.model.Strap;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Filip Wolve
 */
public class StrapDaoImpl implements StrapDao{

    private JdbcTemplate jdbcTemplate; 
    @SuppressWarnings("unused") 
    private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource; 
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Override
    public int getCount() {
        String sql = "SELECT COUNT(*) FROM strap"; 
        int count = jdbcTemplate.queryForObject(sql, Integer.class); 
        return count; 
    }

    @Override
    public List<Strap> getStrapByID(int id) {
        String sql= "SELECT * FROM strap WHERE strap_ID =" + id; 
        List<Strap> straps= jdbcTemplate.query(sql, new StrapMapper()); 
        return straps;
    }

    @Override
    public List<Strap> getAllStraps() {
        String sql= "SELECT * FROM strap"; 
        List<Strap> straps= jdbcTemplate.query(sql, new StrapMapper()); 
        return straps;
    }

    @Override
    public boolean addStrap(Strap strap) {
        String sql = "INSERT INTO strap " + "(strap_ID, name, description, picture) VALUES (?, ?, ?,?)"; 
        jdbcTemplate.update(sql, new Object[] {
            strap.getStrapID(), 
            strap.getName(), 
            strap.getDescription(),
            strap.getPicture()
        });
        return true; 
    }

    @Override
    public boolean removeStrap(String name) {
        String sql = "DELETE FROM strap WHERE name= " + name;
        jdbcTemplate.update(sql);
        return true;
    }

    @Override
    public boolean updateStrap(Strap strap) {
        String sql = "UPDATE strap set name = ?, description =?, picture=? where strap_ID = ?"; 
        jdbcTemplate.update(sql, new Object[] {
            strap.getName(),
            strap.getDescription(),
            strap.getPicture(),
            strap.getStrapID()
        });
        return true; 
    }
    
}
