/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.filip.service.impl;

import com.it355.filip.dao.UsersDao;
import com.it355.filip.model.Users;
import com.it355.filip.service.UsersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Filip Wolve
 */
public class UsersServiceImpl implements UsersService{

    @Autowired
    UsersDao usersDao;
    
    @Override
    public int getCount() {
        return usersDao.getCount();
    }

    @Override
    public List<Users> getAllUsers() {
        return usersDao.getAllUsers();
    }

    @Override
    public boolean addUsers(Users users) {
        return usersDao.addUsers(users);
    }

    @Override
    public boolean removeUsers(String username) {
        return usersDao.removeUsers(username);
    }

    @Override
    public boolean updateUsers(Users users) {
        return usersDao.updateUsers(users);
    }
    
}
