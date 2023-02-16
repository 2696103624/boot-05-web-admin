package com.atguigu.admin.service;

import com.atguigu.admin.bean.City;
import com.atguigu.admin.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: SHU
 * @time: 2022/10/22 12:36
 */

@Service
public class CityService {

    @Autowired
    CityMapper cityMapper;

    public City getById(Long id){
        return cityMapper.getCityById(id);
    }

    public void saveCity(City city) {
        cityMapper.insertCity(city);
    }
}
