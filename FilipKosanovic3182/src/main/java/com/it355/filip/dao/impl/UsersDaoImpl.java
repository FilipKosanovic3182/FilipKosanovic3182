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
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Filip Wolve
 */
@Repository
public class UsersDaoImpl implements UsersDao{
    
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    private JdbcTemplate jdbcTemplate; 
    @SuppressWarnings("unused") 
    private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource; 
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Override
    public int getCount() {
        Session session = this.sessionFactory.getCurrentSession();
        return (int) (Number) session.createCriteria("account").setProjection(Projections.rowCount()).uniqueResult();
        
        /*String sql = "SELECT COUNT(*) FROM account"; 
        int count = jdbcTemplate.queryForObject(sql, Integer.class); 
        return count;    */ 
    }

    @Override
    public List<Users> getAllUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Users> users = session.createQuery("from account").list();
        /*for (Brand b : brands) {
            logger.info("Person List::" + p);
        }*/
        return users;/*
        String sql= "SELECT * FROM account"; 
        List<Users> users= jdbcTemplate.query(sql, new UsersMapper()); 
        return users;    */
    }

    @Override
    public boolean addUsers(Users user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
        return true;
        
        /*String sql = "INSERT INTO account " + "(account_ID, username, password, name, lastName, role) VALUES (?, ?, ?, ?, ?, ?)"; 
        jdbcTemplate.update(sql, new Object[] {
            users.getAccount_ID(), 
            users.getUsername(), 
            users.getPassword(),
            users.getName(),
            users.getLastName(),
            users.getRole()
        });
        return true; */
    }

    @Override
    public boolean removeUsers(String username) {
        Session session = this.sessionFactory.getCurrentSession();
        Users b = (Users) session.load(Users.class, new String(username));
        if (null != b) {
            session.delete(b);
            return true;
        } else {
            return false;
        }
        /*String sql = "DELETE FROM account WHERE username= " + username;
        jdbcTemplate.update(sql);
        return true;*/
    }

    @Override
    public boolean updateUsers(Users user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        return true;
        /*String sql = "UPDATE account set username = ?, password =?, name =?, lastName =?, role =? where account_ID = ?"; 
        jdbcTemplate.update(sql, new Object[] {
            users.getUsername(), 
            users.getPassword(),
            users.getName(),
            users.getLastName(),
            users.getRole(),
            users.getAccount_ID()
        });
        return true; */
    }
    
}
