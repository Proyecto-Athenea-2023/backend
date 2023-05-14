/**
 * <p>Copyright: Copyright (c) 2023</p>
 *
 * <h3>License</h3>
 *
 * Copyright (c) 2023 by Carlos Andres Sierra Virguez. <br>
 * All rights reserved. <br>
 *
 * <p>Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * <ul>
 * <li> Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * <li> Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * <li> Neither the name of the copyright owners, their employers, nor the
 * names of its contributors may be used to endorse or promote products
 * derived from this software without specific prior written permission.
 * </ul>
 * <p>THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 *
 * @author <A HREF="https://www.linkedin.com/in/casierrav/"> Carlos Andres Sierra </A>
 * (E-mail: <A HREF="mailto:carlos.andres.sierra.v@gmail.com">carlos.andres.sierra.v@gmail.com</A> )
 * @version 1.0
 */

package com.sergioarboleda.rent_car.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="cars")
public class Car implements Serializable {

    // Entity attributes definition
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer carId;
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
     * This method returns the car's id
     * @return car's id
     */
    public Integer getIdCar() {
        return carId;
    }

    /**
     * This method returns the car's plate
     * @return car's plate
     */
    public String getPlate() {
        return plate;
    }

    /**
     * This method sets a new car's plate
     * @param plate
     */
    public void setPlate(String plate) {
        this.plate = plate;
    }

    /**
     * This method returns the car's year
     * @return car's year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * This method sets the car's year
     * @param year
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * This method return the car's brand
     * @return car's brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * This method sets the car's brand
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * This method return the car's color
     * @return car's color
     */
    public String getColor() {
        return color;
    }

    /**
     * This method sets the car's color
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * This method return the car's type
     * @return car's type
     */
    public CarType getCarTypeFK() {
        return carTypeFK;
    }

    /**
     * This method sets the CarType based on many-to-one relationship
     * @param carTypeFK
     */
    public void setCarTypeFK(CarType carTypeFK) {
        this.carTypeFK = carTypeFK;
    }

    /**
     * This method return the car's historical reservations
     * @return car's historical reservations
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * This method sets a initial value of historical reservations
     * @param reservations
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
