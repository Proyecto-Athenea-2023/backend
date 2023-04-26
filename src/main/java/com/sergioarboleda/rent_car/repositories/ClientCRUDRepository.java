package com.sergioarboleda.rent_car.repositories;

import com.sergioarboleda.rent_car.models.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientCRUDRepository extends CrudRepository<Client, Integer> {
}
