/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.filip.dao.impl;

import com.it355.filip.dao.DisplayDao;
import com.it355.filip.mapper.DisplayMapper;
import com.it355.filip.model.Display;
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
public class DisplayDaoImpl implements DisplayDao {

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
        return (int) (Number) session.createCriteria("display").setProjection(Projections.rowCount()).uniqueResult();
        
        /*String sql = "SELECT COUNT(*) FROM display";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;*/
    }

    @Override
    public Display getDisplayByID(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Display display = (Display) session.load(Display.class, new Integer(id));
        //logger.info("Person loaded successfully, Person details=" + p);
        return display;
        
        
        /*String sql = "SELECT * FROM display WHERE brand_ID =" + id;
        List<Display> displays = jdbcTemplate.query(sql, new DisplayMapper());
        return displays;*/
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Display> getAllDisplays() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Display> displays = session.createQuery("from display").list();
        /*for (Brand b : brands) {
            logger.info("Person List::" + p);
        }*/
        return displays;/*
        
        /*String sql = "SELECT * FROM display";
        List<Display> displays = jdbcTemplate.query(sql, new DisplayMapper());
        return displays;*/
    }

    @Override
    public boolean addDisplay(Display display) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(display);
        return true;
        
        /*String sql = "INSERT INTO display " + "(display_ID, name, description, picture) VALUES ( ?, ?, ?, ?)";
        jdbcTemplate.update(sql, new Object[]{
            display.getDisplayID(),
            display.getName(),
            display.getDescription(),
            display.getPicture()
        });
        return true;*/
    }

    @Override
    public boolean removeDisplay(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Display b = (Display) session.load(Display.class, new Integer(id));
        if (null != b) {
            session.delete(b);
            return true;
        } else {
            return false;
        }
        /*String sql = "DELETE FROM display WHERE name= " + name;
        jdbcTemplate.update(sql);
        return true;*/
    }

    @Override
    public boolean updateDisplay(Display display) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(display);
        return true;
        /*String sql = "UPDATE display set name = ?, description =?, picture =? where display_ID = ?";
        jdbcTemplate.update(sql, new Object[]{
            display.getName(),
            display.getDescription(),
            display.getPicture(),
            display.getDisplayID()
        });
        return true;*/
    }

}
