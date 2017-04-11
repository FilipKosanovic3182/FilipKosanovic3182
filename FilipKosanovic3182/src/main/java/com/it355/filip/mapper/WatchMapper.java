/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.filip.mapper;

import com.it355.filip.model.Watch;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Filip Wolve
 */
public class WatchMapper implements RowMapper<Watch>{
    @Override
    public Watch mapRow(ResultSet rs, int i) throws SQLException {
        Watch watch = new Watch();
        watch.setWatchID(rs.getInt("watch_ID"));
        watch.setBrandID(rs.getInt("brand_ID"));
        watch.setGender(rs.getString("gender"));
        watch.setWatchCase(rs.getString("case"));
        watch.setDisplayID(rs.getInt("display_ID"));
        watch.setStrapID(rs.getInt("strap_ID"));
        watch.setPrice(rs.getDouble("price"));
        watch.setAmount(rs.getInt("amount"));
        watch.setModel(rs.getString("model"));
        watch.setModelYear(rs.getInt("model_year"));
        watch.setDescription(rs.getString("description"));
        watch.setWaterproof(rs.getBoolean("waterproof"));
        watch.setSpecialOffer(rs.getBoolean("special_offer"));
        return watch;
    }   
    
}
