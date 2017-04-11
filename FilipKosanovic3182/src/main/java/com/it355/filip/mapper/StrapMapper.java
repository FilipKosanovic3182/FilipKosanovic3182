/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.filip.mapper;

import com.it355.filip.model.Strap;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Filip Wolve
 */
public class StrapMapper implements RowMapper<Strap>{
    @Override
    public Strap mapRow(ResultSet rs, int i) throws SQLException {
        Strap strap = new Strap();
        strap.setStrapID(rs.getInt("strap_ID"));
        strap.setName(rs.getString("name"));
        strap.setDescription(rs.getString("description"));
        strap.setPicture(rs.getString("picture"));
        return strap;
    }   
}
