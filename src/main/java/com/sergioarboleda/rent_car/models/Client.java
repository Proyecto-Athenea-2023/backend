package com.sergioarboleda.rent_car.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="clients")
public class Client implements Serializable {

    @Id
    private Integer idClient;

    @Column(name="names", length = 50, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String lastnames;

    @Column(length = 50, nullable = false)
    private String address;

    @Column(length = 50, nullable = false)
    private String phones;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(length = 50, nullable = false, unique = true)
    private String nickname;

    @Column(length = 50, nullable = false)
    private String password;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "clientFK")
    @JsonIgnoreProperties("clientFK")
    private List<PQR> pqrs;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "clientFK")
    @JsonIgnoreProperties("clientFK")
    private List<Reservation> reservations;

    /**
     *
     * @return
     */
    public Integer getIdClient() {
        return idClient;
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
    public String getLastnames() {
        return lastnames;
    }

    /**
     *
     * @param lastnames
     */
    public void setLastnames(String lastnames) {
        this.lastnames = lastnames;
    }

    /**
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return
     */
    public String getPhones() {
        return phones;
    }

    /**
     *
     * @param phones
     */
    public void setPhones(String phones) {
        this.phones = phones;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getNickname() {
        return nickname;
    }

    /**
     *
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public List<PQR> getPqrs() {
        return pqrs;
    }

    /**
     *
     * @param pqrs
     */
    public void setPqrs(List<PQR> pqrs) {
        this.pqrs = pqrs;
    }

    /**
     *
     * @return
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     *
     * @param reservations
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
