package com.it355.filip.dao.impl;

import com.it355.filip.dao.PicturesDao;
import com.it355.filip.mapper.PicturesMapper;
import com.it355.filip.model.Pictures;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Filip Wolve
 */
public class PicturesDaoImpl implements PicturesDao{
    
    private JdbcTemplate jdbcTemplate; 
    @SuppressWarnings("unused") 
    private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource; 
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int getCount() {
        String sql = "SELECT COUNT(*) FROM pictures"; 
        int count = jdbcTemplate.queryForObject(sql, Integer.class); 
        return count; 
    }

    @Override
    public List<Pictures> getPicturesByID(int id) {
        String sql= "SELECT * FROM brand WHERE picture_ID =" + id; 
        List<Pictures> picture= jdbcTemplate.query(sql, new PicturesMapper()); 
        return picture;
    }

    @Override
    public List<Pictures> getAllPictures() {
        String sql= "SELECT * FROM pictures"; 
        List<Pictures> picture= jdbcTemplate.query(sql, new PicturesMapper()); 
        return picture;
    }

    @Override
    public boolean addPicture(Pictures picture) {
        String sql = "INSERT INTO pictures " + "(picture_ID, watch_ID, path, title, description) VALUES (?, ?, ?, ?, ?)"; 
        jdbcTemplate.update(sql, new Object[] {
            picture.getPicture_ID(), 
            picture.getWatch_ID(), 
            picture.getPath(),
            picture.getTitle(),
            picture.getDescription()
        });
        return true; 
    }

    @Override
    public boolean removePicture(int pictureID) {
        String sql = "DELETE FROM pictures WHERE picture_ID= " + pictureID;
        jdbcTemplate.update(sql);
        return true;
    }

    @Override
    public boolean updatePicture(Pictures picture) {
        String sql = "UPDATE pictures set watch_ID = ?, path =?, title =?, description =? where picture_ID = ?";
        jdbcTemplate.update(sql, new Object[] {
            picture.getWatch_ID(), 
            picture.getPath(),
            picture.getTitle(),
            picture.getDescription(),
            picture.getPicture_ID()
        });
        return true; 
    }
    
    
}
