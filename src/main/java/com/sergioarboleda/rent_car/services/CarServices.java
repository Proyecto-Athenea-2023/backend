package com.sergioarboleda.rent_car.services;

import com.sergioarboleda.rent_car.models.Car;
import com.sergioarboleda.rent_car.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServices {
    @Autowired
    private CarRepository carRepository;

    /**
     * This method gets all cars persisted in the database
     * @return car's list
     */
    public List<Car> getAllCars(){
       return this.carRepository.getAll();
    }

    /**
     *
     * @param year
     * @return
     */
    public List<Car> getAllCarsByYear(Integer year){
       if(year < 1980) // There is no cars older than 1980
           return null;
       return carRepository.getAllByYear(year);
    }

    /**
     *
     * @param carId
     * @return
     */
    public Optional<Car> getCarById(Integer carId){
        return carRepository.getById(carId);
    }

    /**
     *
     * @param plate
     * @return
     */
    public Optional<Car> getCarByPlate(String plate){
        if(Utilities.validatePlate(plate))
            return carRepository.getByPlate(plate);
        else
            return null;
    }


    /**
     *
     * @param car
     * @return
     */
    public Car insertCar(Car car){
        // TODO how to deal with car to insert with an ID?
        if((car.getPlate() != null) && (car.getYear() != null) && (car.getBrand() != null) &&
                (car.getColor() != null) && car.getCarTypeFK() != null){
            if(Utilities.validatePlate(car.getPlate())) {
                Optional<Car> temp = carRepository.getByPlate(car.getPlate());
                if (temp.isEmpty() && car.getYear() > 1950)
                    return carRepository.save(car);
                else
                    return car;
            }
            else
                return car;
        }
        else
            return car;
    }

    /**
     *
     * @param car
     * @return
     */
    public Car updateCar(Car car){
        if(car.getIdCar() != null){
            Optional<Car> temp = carRepository.getById(car.getIdCar());
            if(temp.isPresent()){
                if(car.getBrand() != null)
                    temp.get().setBrand(car.getBrand());
                if(car.getColor() != null)
                    temp.get().setColor(car.getColor());
                if(car.getCarTypeFK() != null)
                    temp.get().setCarTypeFK(car.getCarTypeFK());
                return carRepository.save(temp.get());
            }
            else
                return car;
        }
        else
            return car;
    }

    /**
     *
     * @param carId
     * @return
     */
    public Boolean deleteCar(Integer carId){
        Boolean success = getCarById(carId).map(car -> {
            carRepository.delete(car);
            return true;
        }).orElse(false);
        return success;
    }
}
