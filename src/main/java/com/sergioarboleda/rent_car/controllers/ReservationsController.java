package com.sergioarboleda.rent_car.controllers;

import com.sergioarboleda.rent_car.models.Reservation;
import com.sergioarboleda.rent_car.services.ReservationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservations")
public class ReservationsController {

    @Autowired
    private ReservationServices reservationServices;

    @GetMapping("/all")
    public List<Reservation> getAllReservations(){
        return reservationServices.getAllReservations();
    }

    @GetMapping("/all/{start_date}/{end_path}/status/{status}")
    public List<Reservation> getAllReservationsByDatesAndStatus(@PathVariable("start_date") String start_date,
                                                                @PathVariable("end_date") String end_date,
                                                                @PathVariable("status") String status){
        return reservationServices.getAllReservationsByDatesAndStatus(start_date, end_date, status);
    }

    @GetMapping("/by_id/{id}")
    public Optional<Reservation> getById(@PathVariable("id") Integer reservationId){
        return reservationServices.getReservationById(reservationId);
    }

    @PostMapping("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation insertReservation(@RequestBody Reservation reservation){
        return reservationServices.insertReservation(reservation);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation updateReservation(@RequestBody Reservation reservation){
        return reservationServices.updateReservation(reservation);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteReservation(@PathVariable("id") Integer reservationId){
        return reservationServices.deleteReservation(reservationId);
    }
}
