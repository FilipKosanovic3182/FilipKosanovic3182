/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.filip.mapper;

import com.it355.filip.model.Pictures;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Filip Wolve
 */
public class PicturesMapper implements RowMapper<Pictures>{
    @Override
    public Pictures mapRow(ResultSet rs, int i) throws SQLException {
        Pictures picture = new Pictures();
        picture.setPicture_ID(rs.getInt("picture_ID"));
        picture.setWatch_ID(rs.getInt("watch_ID"));
        picture.setPath(rs.getString("path"));
        picture.setTitle(rs.getString("title"));
        picture.setDescription(rs.getString("description"));
        return picture;
    }
    
}
