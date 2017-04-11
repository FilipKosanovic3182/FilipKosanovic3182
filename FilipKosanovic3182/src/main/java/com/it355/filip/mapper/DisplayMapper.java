/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.filip.mapper;

import com.it355.filip.model.Display;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Filip Wolve
 */
public class DisplayMapper implements RowMapper<Display>{
    @Override
    public Display mapRow(ResultSet rs, int i) throws SQLException {
        Display display = new Display();
        display.setDisplayID(rs.getInt("display_ID"));
        display.setName(rs.getString("name"));
        display.setDescription(rs.getString("description"));
        display.setPicture(rs.getString("picture"));
        return display;
    }
}
