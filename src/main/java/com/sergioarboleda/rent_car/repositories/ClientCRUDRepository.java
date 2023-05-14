package com.sergioarboleda.rent_car.repositories;

import com.sergioarboleda.rent_car.models.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientCRUDRepository extends CrudRepository<Client, Integer> {
    Optional<Client> findByNickname(String nickname);
    Optional<Client> findByEmail(String email);

    /**
     * SELECT count(*) AS exists
     * FROM client
     * WHERE nickname=? AND password=?;
     */
}
