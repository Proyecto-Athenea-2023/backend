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
@Table(name="clients")
public class Client implements Serializable {

    // Entity attributes definition
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
     * This method returns the client's id
     * @return
     */
    public Integer getIdClient() {
        return idClient;
    }

    /**
     * This method returns the client's names
     * @return client's names
     */
    public String getName() {
        return name;
    }

    /**
     * This method sets the client's names
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method returns the client's lastnames
     * @return
     */
    public String getLastnames() {
        return lastnames;
    }

    /**
     * This method sets the client's lastnames
     * @param lastnames
     */
    public void setLastnames(String lastnames) {
        this.lastnames = lastnames;
    }

    /**
     * This method returns the client's address
     * @return client's address
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method sets the client's address
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * This method returns the client's phones
     * @return client's phones
     */
    public String getPhones() {
        return phones;
    }

    /**
     * This method sets the client's phones
     * @param phones
     */
    public void setPhones(String phones) {
        this.phones = phones;
    }

    /**
     * This method returns the client's email
     * @return client's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method sets the client's email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method returns the client's nickname
     * @return client's nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method sets the client's nickname
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * This method returns the client's password
     * @return client's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method sets the client's password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method returns the client's pqrs based on a one-to-many relationship
     * @return client's historical pqrs
     */
    public List<PQR> getPqrs() {
        return pqrs;
    }

    /**
     * This method sets an initial list of historical client's pqrs
     * @param pqrs
     */
    public void setPqrs(List<PQR> pqrs) {
        this.pqrs = pqrs;
    }

    /**
     * This method returns the historical list of client's reservations
     * @return historical client's reservations
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * This method sets a initial list of historical reservations of the client
     * @param reservations
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
