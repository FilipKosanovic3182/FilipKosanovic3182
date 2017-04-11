/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.filip.dao;

import com.it355.filip.model.Users;
import java.util.List;

/**
 *
 * @author Filip Wolve
 */
public interface UsersDao {
    public int getCount();
    public List<Users> getAllUsers();
    public boolean addUsers(Users users);
    public boolean removeUsers(String username);
    public boolean updateUsers(Users users);
}
