package com.sergioarboleda.rent_car.controllers;

import com.sergioarboleda.rent_car.services.ReservationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservations")
public class ReservationsController {

    @Autowired
    private ReservationServices reservationServices;
}
