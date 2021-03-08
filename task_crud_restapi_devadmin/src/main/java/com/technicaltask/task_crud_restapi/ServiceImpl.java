package com.technicaltask.task_crud_restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
class ServiceImpl implements IService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private int type;
    private CityDAOImpl cityDAO;

    public ServiceImpl(CityDAOImpl cityDAO) {
        this.cityDAO = cityDAO;
    }
    @Override
    public String query(String query) {
        type = cityDAO.getType();
        switch(type) {
            case 0:
            case 1:
                jdbcTemplate.execute(query);;
                break;
            case 2:
            case 3:
              return jdbcTemplate.update(query)+"";
            case 4:
               return setListToString(jdbcTemplate.queryForList(query));

        }
        return null;
    }

    private String setListToString(List<Map<String, Object>> cities) {
        if (cities.isEmpty()) {
            return "Not found Cities";
        }
        StringBuilder sb = new StringBuilder();
        cities.stream().forEach(mapsData->{
            mapsData.entrySet().forEach(mapData->{
                sb.append(mapData.getKey()).append(" ").append(mapData.getValue()).append(",");
            });
            sb.setLength(sb.length() - 1);
            sb.append(";");
        });
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
