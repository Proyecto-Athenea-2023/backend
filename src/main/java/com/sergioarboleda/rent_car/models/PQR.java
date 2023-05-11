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

@Entity
@Table(name="pqrs")
public class PQR implements Serializable {

    // Entity attributes definition
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPqr;
    @Column(length = 10, nullable = false)
    private String type;
    @Column(length = 300, nullable = false)
    private String content;
    @Column(nullable = false)
    private String creationDate;

    @ManyToOne
    @JoinColumn(name="idClient")
    @JsonIgnoreProperties("pqrs")
    private Client clientFK;

    /**
     * This method returns the pqr's id
     * @return pqr's id
     */
    public Integer getIdPqr() {
        return idPqr;
    }

    /**
     * This method returns the pqr's type
     * @return pqr's type
     */
    public String getType() {
        return type;
    }

    /**
     * This method sets the pqr's type
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * This method returns the pqr's content
     * @return pqr's content
     */
    public String getContent() {
        return content;
    }

    /**
     * This method sets the pqr's content
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * This method returns the pqr's client based on a one-to-many relation
     * @return pqr's client
     */
    public Client getClientFK() {
        return clientFK;
    }

    /**
     * This method sets the pqr's client based on a one-to-many relation
     * @param clientFK
     */
    public void setClientFK(Client clientFK) {
        this.clientFK = clientFK;
    }

    /**
     * This method returns the pqr's creation date
     * @return pqr's creation date
     */
    public String getCreationDate() {
        return creationDate;
    }

    /**
     * This method sets the pqr's creation date
     * @param creationDate
     */
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
}
