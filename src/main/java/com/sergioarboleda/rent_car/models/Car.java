package com.sergioarboleda.rent_car.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="cars")
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCar;

    @Column(length = 10, nullable = false, unique = true)
    private String plate;

    @Column(nullable = false)
    private Integer year;

    @Column(length = 20, nullable = false)
    private String brand;

    @Column(length = 15, nullable = false)
    private String color;

    @ManyToOne
    @JoinColumn(name="carTypeId")
    @JsonIgnoreProperties("cars")
    private CarType carTypeFK;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "carFK")
    @JsonIgnoreProperties("carFK")
    private List<Reservation> reservations;
}
