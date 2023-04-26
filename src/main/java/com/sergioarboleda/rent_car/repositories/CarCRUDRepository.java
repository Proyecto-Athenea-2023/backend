package com.sergioarboleda.rent_car.repositories;

import com.sergioarboleda.rent_car.models.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarCRUDRepository extends CrudRepository<Car, Integer> {
}
