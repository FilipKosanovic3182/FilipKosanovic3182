/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.filip.mapper;

import com.it355.filip.model.Brand;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Filip Wolve
 */
public class BrandMapper implements RowMapper<Brand>{
    @Override
    public Brand mapRow(ResultSet rs, int i) throws SQLException {
        Brand brand = new Brand();
        brand.setBrandID(rs.getInt("brand_ID"));
        brand.setName(rs.getString("name"));
        brand.setCountry(rs.getString("country"));
        brand.setDescription(rs.getString("description"));
        brand.setPicture(rs.getString("picture"));
        return brand;
    }
}
