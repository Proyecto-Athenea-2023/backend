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

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="employees")
public class Employ implements Serializable {

    // Entity attributes definition
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmploy;
    @Column(length = 100, nullable = false)
    private String name;
    private Boolean isAdmin = false;

    @ManyToMany(mappedBy = "employees")
    private Set<Reservation> reservations;

    /**
     * This method returns the employ's id
     * @return employ's id
     */
    public Integer getIdEmploy() {
        return idEmploy;
    }

    /**
     * This method returns the employ's name
     * @return employ's name
     */
    public String getName() {
        return name;
    }

    /**
     * This method sets the employ's name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method returns if the employ is admin
     * @return is admin?
     */
    public Boolean getIsAdmin() {
        return isAdmin;
    }

    /**
     * This method sets the employ status as admin
     * @param is_admin
     */
    public void setIsAdmin(Boolean is_admin) {
        this.isAdmin = is_admin;
    }

    /**
     * This method returns the reservations modified by the employ
     * @return reservations
     */
    public Set<Reservation> getReservations() {
        return reservations;
    }

    /**
     * This method sets a initial list of reservations modified by the employ
     * @param reservations
     */
    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }
}
