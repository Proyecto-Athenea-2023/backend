package com.sergioarboleda.rent_car.repositories;

import com.sergioarboleda.rent_car.models.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientCRUDRepository extends CrudRepository<Client, Integer> {
    public Optional<Client> findByNickname(String nickname);
    public Optional<Client> findByEmail(String email);
}
