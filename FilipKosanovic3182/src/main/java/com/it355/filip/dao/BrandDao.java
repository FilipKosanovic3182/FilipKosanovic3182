/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.filip.dao;

import com.it355.filip.model.Brand;
import java.util.List;

/**
 *
 * @author Filip Wolve
 */
public interface BrandDao {
    public int getCount();
    public Brand getBrandByID(int id);
    public List<Brand> getAllBrands();
    public boolean addBrand(Brand brand);
    public boolean removeBrand(int id);
    public boolean updateBrand(Brand brand);
}
