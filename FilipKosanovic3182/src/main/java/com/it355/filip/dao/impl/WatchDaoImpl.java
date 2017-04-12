/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.filip.dao.impl;

import com.it355.filip.dao.WatchDao;
import com.it355.filip.mapper.WatchMapper;
import com.it355.filip.model.Watch;
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
public class WatchDaoImpl implements WatchDao{
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
        return (int) (Number) session.createCriteria("watch").setProjection(Projections.rowCount()).uniqueResult();
        /*
        String sql = "SELECT COUNT(*) FROM watch"; 
        int count = jdbcTemplate.queryForObject(sql, Integer.class); 
        return count; */
    }

    @Override
    public Watch getWatchByID(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Watch watch = (Watch) session.load(Watch.class, new Integer(id));
        //logger.info("Person loaded successfully, Person details=" + p);
        return watch;
        /*
        String sql= "SELECT * FROM watch WHERE watch_ID =" + id; 
        List<Watch> watches= jdbcTemplate.query(sql, new WatchMapper()); 
        return watches;*/
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Watch> getAllWatches() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Watch> watches = session.createQuery("from watch").list();
        /*for (Brand b : brands) {
            logger.info("Person List::" + p);
        }*/
        return watches;/*
        String sql= "SELECT * FROM watch"; 
        List<Watch> watches= jdbcTemplate.query(sql, new WatchMapper()); 
        return watches;*/
    }

    @Override
    public boolean addWatch(Watch watch) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(watch);
        return true;
        /*String sql = "INSERT INTO watch " + "(watch_ID, brand_ID, gender, case, display_ID, strap_ID, price, amount, model, model_year, description, waterproof, special_offer) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
        jdbcTemplate.update(sql, new Object[] {
            watch.getWatchID(),
            watch.getBrandID(),
            watch.getGender(),
            watch.getWatchCase(),
            watch.getDisplayID(),
            watch.getStrapID(),
            watch.getPrice(),
            watch.getAmount(),
            watch.getModel(),
            watch.getModelYear(),
            watch.getDescription(),
            watch.getWaterproof(),
            watch.getSpecialOffer()
        });
        return true;*/
    }

    @Override
    public boolean removeWatch(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Watch b = (Watch) session.load(Watch.class, new Integer(id));
        if (null != b) {
            session.delete(b);
            return true;
        } else {
            return false;
        }
        /*String sql = "DELETE FROM watch WHERE model= " + model;
        jdbcTemplate.update(sql);
        return true;*/
    }

    @Override
    public boolean updateWatch(Watch watch) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(watch);
        return true;
        /*String sql = "UPDATE watch set brand_ID =?, gender =?, case =?, display_ID=?, strap_ID =?, price =?, amount =?, model =?, model_year =?, description =?, waterproof =?, special_offer =? where watch_ID = ?"; 
        jdbcTemplate.update(sql, new Object[] {
            watch.getBrandID(),
            watch.getGender(),
            watch.getWatchCase(),
            watch.getDisplayID(),
            watch.getStrapID(),
            watch.getPrice(),
            watch.getAmount(),
            watch.getModel(),
            watch.getModelYear(),
            watch.getDescription(),
            watch.getWaterproof(),
            watch.getSpecialOffer(),
            watch.getWatchID()
        });
        return true; */
    }

    @Override
    public List<Watch> getWatchesOnOffer() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Watch> watches = session.createQuery("from watch where special_offer = 1").list();
        return watches;
        /*String sql= "SELECT * FROM watch WHERE special_offer = 1"; 
        List<Watch> watches= jdbcTemplate.query(sql, new WatchMapper()); 
        return watches;*/
    }

    @Override
    public List<Watch> getWatchesWithBrand(int brandID) {  
        Session session = this.sessionFactory.getCurrentSession();
        List<Watch> watches = session.createQuery("from watch where brand_ID = " + brandID).list();
        return watches;
        
        /*String sql= "SELECT * FROM watch WHERE brand_ID = " + brandID; 
        List<Watch> watches= jdbcTemplate.query(sql, new WatchMapper()); 
        return watches;*/
    }

    @Override
    public List<Watch> getWatchesWithGender(String gender) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Watch> watches = session.createQuery("from watch where gender =" + gender).list();
        return watches;
        /*String sql= "SELECT * FROM watch WHERE gender = " + gender; 
        List<Watch> watches= jdbcTemplate.query(sql, new WatchMapper()); 
        return watches;*/
    }

    @Override
    public List<Watch> getWatchesWithDisplay(int displayID) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Watch> watches = session.createQuery("from watch where display_ID =" + displayID).list();
        return watches;
        /*
        String sql= "SELECT * FROM watch WHERE display_ID = " + displayID; 
        List<Watch> watches= jdbcTemplate.query(sql, new WatchMapper()); 
        return watches;*/
    }

    @Override
    public List<Watch> getWatchesWithStrap(int strapID) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Watch> watches = session.createQuery("from watch where strap_ID =" + strapID).list();
        return watches;
        /*String sql= "SELECT * FROM watch WHERE strap_ID = " + strapID; 
        List<Watch> watches= jdbcTemplate.query(sql, new WatchMapper()); 
        return watches;*/
    }

    @Override
    public List<Watch> getWatchesWithWaterproof() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Watch> watches = session.createQuery("from watch where waterproof = 1").list();
        return watches;
        
        /*String sql= "SELECT * FROM watch WHERE waterproof = 1"; 
        List<Watch> watches= jdbcTemplate.query(sql, new WatchMapper()); 
        return watches;*/
    }
    
}
