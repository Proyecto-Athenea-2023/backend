package com.sergioarboleda.rent_car.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="car_types")
public class CarType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer carTypeId;

    @Column(length = 20)
    private String line;

    @Column(length = 15, nullable = false)
    private String level;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "carTypeFK")
    @JsonIgnoreProperties("carTypeFK")
    private List<Car> cars;

    public Integer getCarTypeId() {
        return carTypeId;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
