/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.filip.dao.impl;

import com.it355.filip.dao.UsersDao;
import com.it355.filip.mapper.UsersMapper;
import com.it355.filip.model.Users;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Filip Wolve
 */
public class UsersDaoImpl implements UsersDao{

    private JdbcTemplate jdbcTemplate; 
    @SuppressWarnings("unused") 
    private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource; 
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Override
    public int getCount() {
        String sql = "SELECT COUNT(*) FROM account"; 
        int count = jdbcTemplate.queryForObject(sql, Integer.class); 
        return count;     
    }

    @Override
    public List<Users> getAllUsers() {
        String sql= "SELECT * FROM account"; 
        List<Users> users= jdbcTemplate.query(sql, new UsersMapper()); 
        return users;    
    }

    @Override
    public boolean addUsers(Users users) {
        String sql = "INSERT INTO account " + "(account_ID, username, password, name, lastName, role) VALUES (?, ?, ?, ?, ?, ?)"; 
        jdbcTemplate.update(sql, new Object[] {
            users.getAccount_ID(), 
            users.getUsername(), 
            users.getPassword(),
            users.getName(),
            users.getLastName(),
            users.getRole()
        });
        return true; 
    }

    @Override
    public boolean removeUsers(String username) {
        String sql = "DELETE FROM account WHERE username= " + username;
        jdbcTemplate.update(sql);
        return true;
    }

    @Override
    public boolean updateUsers(Users users) {
        String sql = "UPDATE account set username = ?, password =?, name =?, lastName =?, role =? where account_ID = ?"; 
        jdbcTemplate.update(sql, new Object[] {
            users.getUsername(), 
            users.getPassword(),
            users.getName(),
            users.getLastName(),
            users.getRole(),
            users.getAccount_ID()
        });
        return true; 
    }
    
}
