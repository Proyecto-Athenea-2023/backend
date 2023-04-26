package com.sergioarboleda.rent_car.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="pqrs")
public class PQR implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPqr;

    @Column(length = 10, nullable = false)
    private String type;

    @Column(length = 300, nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name="idClient")
    @JsonIgnoreProperties("pqrs")
    private Client clientFK;
}
