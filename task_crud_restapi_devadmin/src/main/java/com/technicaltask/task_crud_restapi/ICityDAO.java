package com.technicaltask.task_crud_restapi;

import java.util.List;

public interface ICityDAO {
    void createTable();
    void insert(City city);
    String update(City city, int id);
    String delete(int id);
    String getCity();
    City findById(int id);
}
