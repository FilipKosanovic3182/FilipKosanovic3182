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
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Filip Wolve
 */
public class BrandServiceImpl implements BrandService{
    @Autowired
    BrandDao brandDao;
    @Override
    public int getCount() {
        return brandDao.getCount();
    }

    @Override
    public List<Brand> getBrandByID(int id) {
        return brandDao.getBrandByID(id);
    }

    @Override
    public List<Brand> getAllBrands() {
        return brandDao.getAllBrands();
    }

    @Override
    public boolean addBrand(Brand brand) {
        return brandDao.addBrand(brand);
    }

    @Override
    public boolean removeBrand(String name) {
        return brandDao.removeBrand(name);
    }

    @Override
    public boolean updateBrand(Brand brand) {
        return brandDao.updateBrand(brand);
    }
    
}
