/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.filip.dao.impl;

import com.it355.filip.dao.BrandDao;
import com.it355.filip.mapper.BrandMapper;
import com.it355.filip.model.Brand;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Filip Wolve
 */
public class BrandDaoImpl implements BrandDao{
    
    private JdbcTemplate jdbcTemplate; 
    @SuppressWarnings("unused") 
    private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource; 
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    

    @Override
    public int getCount() {
        String sql = "SELECT COUNT(*) FROM brand"; 
        int count = jdbcTemplate.queryForObject(sql, Integer.class); 
        return count; 
    }

    @Override
    public List<Brand> getBrandByID(int id) {
        String sql= "SELECT * FROM brand WHERE brand_ID =" + id; 
        List<Brand> brands= jdbcTemplate.query(sql, new BrandMapper()); 
        return brands;
    }

    @Override
    public List<Brand> getAllBrands() {
        String sql= "SELECT * FROM brand"; 
        List<Brand> brands= jdbcTemplate.query(sql, new BrandMapper()); 
        return brands;
    }

    @Override
    public boolean addBrand(Brand brand) {
        String sql = "INSERT INTO brand " + "(brand_ID, name, country, description, picture) VALUES (?, ?, ?, ?, ?)"; 
        jdbcTemplate.update(sql, new Object[] {
            brand.getBrandID(), 
            brand.getName(), 
            brand.getCountry(),
            brand.getDescription(),
            brand.getPicture()
        });
        return true; 
    }

    @Override
    public boolean removeBrand(String name) {
        String sql = "DELETE FROM brand WHERE name= " + name;
        jdbcTemplate.update(sql);
        return true;
    }

    @Override
    public boolean updateBrand(Brand brand) {
        String sql = "UPDATE brand set name = ?, country =?, description =?, picture =? where brand_ID = ?";
        jdbcTemplate.update(sql, new Object[] {
            brand.getName(),
            brand.getCountry(),
            brand.getDescription(),
            brand.getPicture(),
            brand.getBrandID()
            
        });
        return true; 
    }
    
}
