package com.sergioarboleda.rent_car.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="reservations")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;

    @Column(length = 30, nullable = false)
    private String status;

    @Column(nullable = false)
    private String startDate;

    @Column(nullable = false)
    private String endDate;

    @Column(nullable = false)
    private Integer cost;

    private Integer grade;

    @Column(length = 200)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "idCar")
    @JsonIgnoreProperties("reservations")
    private Car carFK;

    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties("reservations")
    private Client clientFK;

    @ManyToMany
    @JoinTable(
            name = "log_reservations",
            joinColumns = @JoinColumn(name = "idReservation"),
            inverseJoinColumns = @JoinColumn(name = "idEmploy")
    )
    private Set<Employ> employees;
}
