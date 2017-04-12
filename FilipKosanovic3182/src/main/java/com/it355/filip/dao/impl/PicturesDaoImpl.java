package com.it355.filip.dao.impl;

import com.it355.filip.dao.PicturesDao;
import com.it355.filip.mapper.PicturesMapper;
import com.it355.filip.model.Pictures;
import java.util.List;
import javax.sql.DataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Filip Wolve
 */
@Repository
public class PicturesDaoImpl implements PicturesDao{
    
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
        return (int) (Number) session.createCriteria("pictures").setProjection(Projections.rowCount()).uniqueResult();
        
        /*String sql = "SELECT COUNT(*) FROM pictures"; 
        int count = jdbcTemplate.queryForObject(sql, Integer.class); 
        return count; */
    }

    @Override
    public Pictures getPicturesByID(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Pictures picture = (Pictures) session.load(Pictures.class, new Integer(id));
        //logger.info("Person loaded successfully, Person details=" + p);
        return picture;
        
        /*String sql= "SELECT * FROM brand WHERE picture_ID =" + id; 
        List<Pictures> picture= jdbcTemplate.query(sql, new PicturesMapper()); 
        return picture;*/
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Pictures> getAllPictures() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Pictures> pictures = session.createQuery("from pictures").list();
        /*for (Brand b : brands) {
            logger.info("Person List::" + p);
        }*/
        return pictures;/*
        
        String sql= "SELECT * FROM pictures"; 
        List<Pictures> picture= jdbcTemplate.query(sql, new PicturesMapper()); 
        return picture;*/
    }

    @Override
    public boolean addPicture(Pictures picture) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(picture);
        return true;
        
        /*String sql = "INSERT INTO pictures " + "(picture_ID, watch_ID, path, title, description) VALUES (?, ?, ?, ?, ?)"; 
        jdbcTemplate.update(sql, new Object[] {
            picture.getPicture_ID(), 
            picture.getWatch_ID(), 
            picture.getPath(),
            picture.getTitle(),
            picture.getDescription()
        });
        return true; */
    }

    @Override
    public boolean removePicture(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Pictures picture = (Pictures) session.load(Pictures.class, new Integer(id));
        if (null != picture) {
            session.delete(picture);
            return true;
        } else {
            return false;
        }
        
        /*String sql = "DELETE FROM pictures WHERE picture_ID= " + pictureID;
        jdbcTemplate.update(sql);
        return true;*/
    }

    @Override
    public boolean updatePicture(Pictures picture) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(picture);
        return true;
        
        /*String sql = "UPDATE pictures set watch_ID = ?, path =?, title =?, description =? where picture_ID = ?";
        jdbcTemplate.update(sql, new Object[] {
            picture.getWatch_ID(), 
            picture.getPath(),
            picture.getTitle(),
            picture.getDescription(),
            picture.getPicture_ID()
        });
        return true; */
    }
    
    
}
