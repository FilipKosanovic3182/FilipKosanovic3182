/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.filip.dao.impl;

import com.it355.filip.dao.BrandDao;
import com.it355.filip.mapper.BrandMapper;
import com.it355.filip.model.Brand;
import java.util.List;
import javax.sql.DataSource;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Filip Wolve
 */
@Repository
public class BrandDaoImpl implements BrandDao {
    private static final Logger logger = LoggerFactory.getLogger(BrandDaoImpl.class);

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
        return (int) (Number) session.createCriteria("brand").setProjection(Projections.rowCount()).uniqueResult();
        /*String sql = "SELECT COUNT(*) FROM brand";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;*/
    }

    @Override
    public Brand getBrandByID(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Brand brand = (Brand) session.load(Brand.class, new Integer(id));
        //logger.info("Person loaded successfully, Person details=" + p);
        return brand;

        /*String sql = "SELECT * FROM brand WHERE brand_ID =" + id;
        List<Brand> brands = jdbcTemplate.query(sql, new BrandMapper());
        return brands;*/
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Brand> getAllBrands() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Brand> brands = session.createQuery("from brand").list();
        /*for (Brand b : brands) {
            logger.info("Person List::" + p);
        }*/
        return brands;/*

        String sql = "SELECT * FROM brand";
        List<Brand> brands = jdbcTemplate.query(sql, new BrandMapper());
        return brands;*/
    }

    @Override
    public boolean addBrand(Brand brand) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(brand);
        return true;
        //logger.info("Person saved successfully, Person Details=" + p);

        /*String sql = "INSERT INTO brand " + "(brand_ID, name, country, description, picture) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, new Object[]{
            brand.getBrandID(),
            brand.getName(),
            brand.getCountry(),
            brand.getDescription(),
            brand.getPicture()
        });
        return true;*/
    }

    @Override
    public boolean removeBrand(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Brand b = (Brand) session.load(Brand.class, new Integer(id));
        if (null != b) {
            session.delete(b);
            return true;
        } else {
            return false;
        }
        //logger.info("Person deleted successfully, person details=" + p);
        /*String sql = "DELETE FROM brand WHERE name= " + name;
        jdbcTemplate.update(sql);
        return true;*/
    }

    @Override
    public boolean updateBrand(Brand brand) {

        Session session = this.sessionFactory.getCurrentSession();
        session.update(brand);
        return true;
        //logger.info("Person updated successfully, Person Details=" + p);

        /*String sql = "UPDATE brand set name = ?, country =?, description =?, picture =? where brand_ID = ?";
        jdbcTemplate.update(sql, new Object[]{
            brand.getName(),
            brand.getCountry(),
            brand.getDescription(),
            brand.getPicture(),
            brand.getBrandID()

        });
        return true;*/
    }

}
