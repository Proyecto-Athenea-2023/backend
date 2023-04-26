package com.sergioarboleda.rent_car.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="clients")
public class Client implements Serializable {

    @Id
    private Integer idClient;

    @Column(name="names", length = 50, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String lastnames;

    @Column(length = 50, nullable = false)
    private String address;

    @Column(length = 50, nullable = false)
    private String phones;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(length = 50, nullable = false, unique = true)
    private String nickname;

    @Column(length = 50, nullable = false)
    private String password;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "clientFK")
    @JsonIgnoreProperties("clientFK")
    private List<PQR> pqrs;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "clientFK")
    @JsonIgnoreProperties("clientFK")
    private List<Reservation> reservations;
}
