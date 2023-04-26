package com.sergioarboleda.rent_car.repositories;

import com.sergioarboleda.rent_car.models.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCRUDRepository extends CrudRepository<Reservation, Integer> {

}
