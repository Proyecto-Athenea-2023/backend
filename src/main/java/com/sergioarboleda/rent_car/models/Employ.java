package com.sergioarboleda.rent_car.models;

import javax.persistence.*;

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

    private Boolean isAdmin = false;

    @ManyToMany(mappedBy = "employees")
    private Set<Reservation> reservations;

    /**
     *
     * @return
     */
    public Integer getIdEmploy() {
        return idEmploy;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public Boolean getIsAdmin() {
        return isAdmin;
    }

    /**
     *
     * @param is_admin
     */
    public void setIsAdmin(Boolean is_admin) {
        this.isAdmin = is_admin;
    }

    /**
     *
     * @return
     */
    public Set<Reservation> getReservations() {
        return reservations;
    }

    /**
     *
     * @param reservations
     */
    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }
}
