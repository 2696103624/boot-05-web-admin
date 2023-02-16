package com.atguigu.admin.mapper;

import com.atguigu.admin.bean.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;

@Mapper

public interface CityMapper {

    @Select("select * from city where id = #{id}")
    public City getCityById(Long id);

    public void insertCity(City city);

}
