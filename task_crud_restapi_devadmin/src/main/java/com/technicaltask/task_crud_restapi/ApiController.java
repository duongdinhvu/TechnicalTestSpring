package com.technicaltask.task_crud_restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "city")
public class ApiController {

    @Autowired
    ICityDAO employeeDAO;

    @GetMapping("/createTable")
    public String create() {
        employeeDAO.createTable();
        return "success";
    }

    @GetMapping("/cities")
    public String getAllCities() {
        return employeeDAO.getCity();
    }

    @PostMapping("/add-city")
    public ResponseEntity createCity(@RequestBody City city) {
        employeeDAO.insert(city);
        return ResponseEntity.ok().body(city);
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable(name = "id") int id,
                      @RequestBody City city) {
      return  Integer.parseInt(employeeDAO.update(city, id)) > 0 ? "Updated" : "Not update";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        return  Integer.parseInt(employeeDAO.delete(id)) > 0 ? "DELETED" : "NOT DELETE";
    }
}
