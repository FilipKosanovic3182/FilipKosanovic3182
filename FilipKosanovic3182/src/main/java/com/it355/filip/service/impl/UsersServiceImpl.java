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
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Filip Wolve
 */
@Service
public class UsersServiceImpl implements UsersService{
    private UsersDao usersDao;
    public void setBrandDAO(UsersDao usersDao) {
        this.usersDao = usersDao;
    }
    /*@Autowired
    UsersDao usersDao;*/
    
    @Override
    @Transactional
    public int getCount() {
        return this.usersDao.getCount();
    }

    @Override
    @Transactional
    public List<Users> getAllUsers() {
        return this.usersDao.getAllUsers();
    }

    @Override
    @Transactional
    public boolean addUsers(Users users) {
        return this.usersDao.addUsers(users);
    }

    @Override
    @Transactional
    public boolean removeUsers(String username) {
        return this.usersDao.removeUsers(username);
    }

    @Override
    @Transactional
    public boolean updateUsers(Users users) {
        return this.usersDao.updateUsers(users);
    }
    
}
