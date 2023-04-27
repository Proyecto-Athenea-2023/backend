package com.sergioarboleda.rent_car.services;

import com.sergioarboleda.rent_car.models.Car;
import com.sergioarboleda.rent_car.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CarServices {
    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCars(){

    }

    public List<Car> getAllCarsByYear(Integer year){

    }

    public Optional<Car> getCarById(Integer id){

    }

    public Optional<Car> getCarByPlate(String plate){

    }

    public Car insertCar(Car car){

    }

    public Car updateCar(Car car){

    }

    public boolean deleteCar(Integer carId){

    }
}
