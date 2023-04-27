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

    /**
     *
     * @return
     */
    public Integer getIdCar() {
        return idCar;
    }

    /**
     *
     * @return
     */
    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public CarType getCarTypeFK() {
        return carTypeFK;
    }

    public void setCarTypeFK(CarType carTypeFK) {
        this.carTypeFK = carTypeFK;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
