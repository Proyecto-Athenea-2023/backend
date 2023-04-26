package com.sergioarboleda.rent_car.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="employees")
public class Employ implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmploy;

    @Column(length = 100, nullable = false)
    private String name;

    private Boolean is_admin = false;

    @ManyToMany(mappedBy = "employees")
    private Set<Reservation> reservations;
}
