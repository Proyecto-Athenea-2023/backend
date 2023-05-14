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
import java.util.Set;

@Entity
@Table(name="reservations")
public class Reservation implements Serializable {

    // Entity attributes definition
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

    /**
     * This method returns the reservation's id
     * @return reservation's id
     */
    public Integer getIdReservation() {
        return idReservation;
    }

    /**
     * This method returns the reservation's status
     * @return reservation's status
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method sets the reservation's status
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * This method returns the reservation's start date
     * @return reservation's start date
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * This method sets the reservation's start date
     * @param startDate
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * This method returns the reservation's end date
     * @return reservation's end date
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * This method sets the reservation's end date
     * @param endDate
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * This method returns the reservation's cost
     * @return reservation's cost
     */
    public Integer getCost() {
        return cost;
    }

    /**
     * This method sets the reservation's cost
     * @param cost
     */
    public void setCost(Integer cost) {
        this.cost = cost;
    }

    /**
     * This method returns the reservation's grade
     * @return reservation's grade
     */
    public Integer getGrade() {
        return grade;
    }

    /**
     * This method sets the reservation's grade
     * @param grade
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    /**
     * This method returns the reservation's comment
     * @return reservation's comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * This method sets the reservation's comment
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * This method returns the reservation's car
     * @return reservation's car
     */
    public Car getCarFK() {
        return carFK;
    }

    /**
     * This method sets the reservation's car
     * @param carFK
     */
    public void setCarFK(Car carFK) {
        this.carFK = carFK;
    }

    /**
     * This method returns the reservation's client
     * @return reservation's client
     */
    public Client getClientFK() {
        return clientFK;
    }

    /**
     * This method sets the reservation's client
     * @param clientFK
     */
    public void setClientFK(Client clientFK) {
        this.clientFK = clientFK;
    }

    /**
     * This method returns the list of employees who changed information of the reservation
     * @return employees' list
     */
    public Set<Employ> getEmployees() {
        return employees;
    }

    /**
     * This method sets an initial list of employees who historically changed information of the reservation
     * @param employees
     */
    public void setEmployees(Set<Employ> employees) {
        this.employees = employees;
    }
}
