package com.sergioarboleda.rent_car.controllers;

import com.sergioarboleda.rent_car.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientsController {

    @Autowired
    private ClientServices clientServices;
}
