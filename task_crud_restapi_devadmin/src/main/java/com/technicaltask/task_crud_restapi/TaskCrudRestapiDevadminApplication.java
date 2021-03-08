package com.technicaltask.task_crud_restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class TaskCrudRestapiDevadminApplication{


    public static void main(String[] args) {
        SpringApplication.run(TaskCrudRestapiDevadminApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//
//        //Insert a record:
////        jdbcTemplate.execute("INSERT INTO beers VALUES ('Stella', 'hcm'), ('aluuu', 'hn')");
////
////        //Read records:
////
////        StringBuilder sb = new StringBuilder();
////        List<Map<String, Object>> beers = jdbcTemplate.queryForList("select * from beers");
////        beers.stream().forEach(mapsData->{
////            mapsData.entrySet().forEach(mapData->{
////                sb.append(mapData.getKey()).append(" ").append(mapData.getValue()).append(",");
////            });
////            sb.setLength(sb.length() - 1);
////            sb.append(";");
////        });
////        sb.setLength(sb.length() - 1);
//////        this.jdbcTemplate.update(
//////                "update beer set = ? where id = ?",
//////                "Banjo", 5276L);
////
////        //Print read records:
////        System.out.println(sb);
//    }
}
