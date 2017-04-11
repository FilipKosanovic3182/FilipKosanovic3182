/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.filip.mapper;

import com.it355.filip.model.Users;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Filip Wolve
 */
public class UsersMapper implements RowMapper<Users>{
    @Override
    public Users mapRow(ResultSet rs, int i) throws SQLException {
        Users users = new Users();
        users.setAccount_ID(rs.getInt("account_ID"));
        users.setUsername(rs.getString("username"));
        users.setPassword(rs.getString("password"));
        users.setName(rs.getString("name"));
        users.setLastName(rs.getString("lastName"));
        users.setRole(rs.getString("role"));
        return users;
    }    
}
