package com.sergioarboleda.rent_car.controllers;

import com.sergioarboleda.rent_car.models.Employ;
import com.sergioarboleda.rent_car.services.EmployServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

    @Autowired
    private EmployServices employServices;

    @GetMapping("/all")
    public List<Employ> getAllEmployees(){
        return employServices.getAllEmployees();
    }

    @GetMapping("/by_id/{id}")
    public Optional<Employ> getEmployById(@PathVariable("id") Integer employId){
        return employServices.getEmployById(employId);
    }

    @PostMapping("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public Employ insertEmploy(@RequestBody Employ employ){
        return employServices.insertEmploy(employ);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Employ updateEmploy(@RequestBody Employ employ){
        return employServices.updateEmploy(employ);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteEmploy(@PathVariable("id") Integer employId){
        return employServices.deleteEmploy(employId);
    }
}
