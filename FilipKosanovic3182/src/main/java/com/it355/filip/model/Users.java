/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.filip.model;

import java.io.Serializable;

/**
 *
 * @author Filip Wolve
 */
@SuppressWarnings("serial")
public class Users implements Serializable{
    private int account_ID;
    private String username;
    private String password;
    private String name;
    private String lastName;
    private String role;

    public int getAccount_ID() {
        return account_ID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRole() {
        return role;
    }

    public void setAccount_ID(int account_ID) {
        this.account_ID = account_ID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Users[" + "userID=" + account_ID + ", username=" + username + ", password=" + password + ", name=" + name + ", lastName=" + lastName + ", role=" + role + ']';
    }
    
    
}
