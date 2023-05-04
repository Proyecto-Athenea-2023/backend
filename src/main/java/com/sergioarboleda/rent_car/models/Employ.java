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

    private Boolean isAdmin = false;

    @ManyToMany(mappedBy = "employees")
    private Set<Reservation> reservations;

    public Integer getIdEmploy() {
        return idEmploy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean is_admin) {
        this.isAdmin = is_admin;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }
}
