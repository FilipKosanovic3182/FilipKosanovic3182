/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.filip.dao.impl;

import com.it355.filip.dao.StrapDao;
import com.it355.filip.mapper.StrapMapper;
import com.it355.filip.model.Strap;
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
public class StrapDaoImpl implements StrapDao{
    
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
        return (int) (Number) session.createCriteria("strap").setProjection(Projections.rowCount()).uniqueResult();
        
        /*String sql = "SELECT COUNT(*) FROM strap"; 
        int count = jdbcTemplate.queryForObject(sql, Integer.class); 
        return count; */
    }

    @Override
    public Strap getStrapByID(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Strap strap = (Strap) session.load(Strap.class, new Integer(id));
        //logger.info("Person loaded successfully, Person details=" + p);
        return strap;
        
        /*String sql= "SELECT * FROM strap WHERE strap_ID =" + id; 
        List<Strap> straps= jdbcTemplate.query(sql, new StrapMapper()); 
        return straps;*/
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Strap> getAllStraps() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Strap> straps = session.createQuery("from strap").list();
        /*for (Brand b : brands) {
            logger.info("Person List::" + p);
        }*/
        return straps;/*
        
        String sql= "SELECT * FROM strap"; 
        List<Strap> straps= jdbcTemplate.query(sql, new StrapMapper()); 
        return straps;*/
    }

    @Override
    public boolean addStrap(Strap strap) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(strap);
        return true;
        
        /*String sql = "INSERT INTO strap " + "(strap_ID, name, description, picture) VALUES (?, ?, ?,?)"; 
        jdbcTemplate.update(sql, new Object[] {
            strap.getStrapID(), 
            strap.getName(), 
            strap.getDescription(),
            strap.getPicture()
        });
        return true; */
    }

    @Override
    public boolean removeStrap(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Strap b = (Strap) session.load(Strap.class, new Integer(id));
        if (null != b) {
            session.delete(b);
            return true;
        } else {
            return false;
        }
        /*
        String sql = "DELETE FROM strap WHERE name= " + name;
        jdbcTemplate.update(sql);
        return true;*/
    }

    @Override
    public boolean updateStrap(Strap strap) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(strap);
        return true;
        
        /*String sql = "UPDATE strap set name = ?, description =?, picture=? where strap_ID = ?"; 
        jdbcTemplate.update(sql, new Object[] {
            strap.getName(),
            strap.getDescription(),
            strap.getPicture(),
            strap.getStrapID()
        });
        return true; */
    }
    
}
