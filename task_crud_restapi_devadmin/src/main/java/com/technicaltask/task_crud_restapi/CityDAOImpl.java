package com.technicaltask.task_crud_restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityDAOImpl implements ICityDAO {
    @Autowired
    private IService service;
    private int type;
    @Override
    public void createTable() {
        this.type = 0;
        String sql = "CREATE TABLE IF NOT EXISTS  city(id int, name varchar(100), countryCode varchar(50), district varchar(255), population int)";
        service.query(sql);
    }

    @Override
    public void insert(City city) {
        this.type = 1;
        String sql = "";
        sql = "INSERT INTO city VALUES (" +city.getId()+ ", '"+city.getName()+"', " +city.getCountryCode()+ ", '"+city.getDistrict()+"', " +city.getPopulation()+ ")";

       service.query(sql);
    }

    @Override
    public String update(City city, int id) {
        this.type = 2;
        StringBuilder  setStr = new StringBuilder();
        setStr.append(city.getName()!= null ? "name='" +city.getName()+ "'" : "");
        setStr.append(city.getCountryCode()!= null ? ", countryCode='" +city.getCountryCode()+ "'": "");
        setStr.append(city.getDistrict()!= null ? ", district='" +city.getDistrict()+ "'": "");
        setStr.append(city.getPopulation()!= 0 ? ", population=" +city.getPopulation(): "");
        setStr.append(" WHERE id=" + id);
        StringBuilder sql = new StringBuilder("UPDATE city set ");
        sql.append(setStr);
        return service.query(sql.toString());
    }

    @Override
    public String delete(int id) {
        this.type = 3;
        String sql = "DELETE FROM city WHERE id=" + id;
        return service.query(sql);
    }

    @Override
    public String getCity() {
        this.type = 4;
        String sql = "SELECT * FROM city";
        return service.query(sql);
    }

    @Override
    public City findById(int id) {
        this.type = 5;
        String sql = "select * from city where id=" + id;
        return null;
    }

    public int getType() {
       return this.type;
    }
}
