package com.sergioarboleda.rent_car.repositories;

import com.sergioarboleda.rent_car.models.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CarCRUDRepository extends CrudRepository<Car, Integer> {

    public Optional<Car> findByPlate(String plate);
    public List<Car> findByYear(Integer year);
}

