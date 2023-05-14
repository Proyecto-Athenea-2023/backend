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
@Table(name="car_types")
public class CarType implements Serializable {

    // Entity attributes definition
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

    /**
     * This method returns the car's type id
     * @return car's type id
     */
    public Integer getCarTypeId() {
        return carTypeId;
    }

    /**
     * This method returns the line of the car's type
     * @return line of the car's type
     */
    public String getLine() {
        return line;
    }

    /**
     * This method sets the line of the car's type
     * @param line
     */
    public void setLine(String line) {
        this.line = line;
    }

    /**
     * This method returns the level of the car's type
     * @return level of the car's type
     */
    public String getLevel() {
        return level;
    }

    /**
     * This method sets the level of the car's type
     * @param level
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * This method returns the list of cars of the car's type based on a one-to-many relationship
     * @return list of cars related to the car's type
     */
    public List<Car> getCars() {
        return cars;
    }

    /**
     * This method sets a initial list of cars related with the car's type
     * @param cars
     */
    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
