package com.sergioarboleda.rent_car.controllers;

import com.sergioarboleda.rent_car.models.PQR;
import com.sergioarboleda.rent_car.services.PQRServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pqrs")
public class PQRController {

    @Autowired
    private PQRServices pqrServices;

    @GetMapping("/all")
    public List<PQR> getAllPQRs(){
        return pqrServices.getAllPQRs();
    }

    @GetMapping("/by_id/{id}")
    public Optional<PQR> getPQRById(@PathVariable("id") Integer pqrId){
        return pqrServices.getPQRById(pqrId);
    }

    @PostMapping("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public PQR insertPqr(@RequestBody PQR pqr){
        return pqrServices.insertPQR(pqr);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public PQR updatePqr(@RequestBody PQR pqr){
        return pqrServices.updatePQR(pqr);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deletePqr(@PathVariable("id") Integer pqrId){
        return pqrServices.deletePQR(pqrId);
    }
}
