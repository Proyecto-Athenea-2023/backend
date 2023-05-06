package com.sergioarboleda.rent_car.repositories;

import com.sergioarboleda.rent_car.models.CarType;
import org.springframework.data.repository.CrudRepository;

public interface CarTypeCRUDRepository extends CrudRepository<CarType, Integer> {
}
