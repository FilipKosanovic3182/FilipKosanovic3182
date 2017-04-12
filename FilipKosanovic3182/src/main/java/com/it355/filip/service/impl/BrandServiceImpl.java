/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.filip.service.impl;

import com.it355.filip.dao.BrandDao;
import com.it355.filip.model.Brand;
import com.it355.filip.service.BrandService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Filip Wolve
 */
@Service
public class BrandServiceImpl implements BrandService {

    private BrandDao brandDao;

    public void setBrandDAO(BrandDao brandDao) {
        this.brandDao = brandDao;
    }

    //@Autowired
    //BrandDao brandDao;
    @Override
    @Transactional
    public int getCount() {
        return this.brandDao.getCount();
    }

    @Override
    @Transactional
    public Brand getBrandByID(int id) {
        return this.brandDao.getBrandByID(id);
    }

    @Override
    @Transactional
    public List<Brand> getAllBrands() {
        return this.brandDao.getAllBrands();
    }

    @Override
    @Transactional
    public boolean addBrand(Brand brand) {
        return this.brandDao.addBrand(brand);
    }

    @Override
    @Transactional
    public boolean removeBrand(int id) {
        return this.brandDao.removeBrand(id);
    }

    @Override
    @Transactional
    public boolean updateBrand(Brand brand) {
        return this.brandDao.updateBrand(brand);
    }

}
