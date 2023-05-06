package com.sergioarboleda.rent_car.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="pqrs")
public class PQR implements Serializable {

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

    public Integer getIdPqr() {
        return idPqr;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Client getClientFK() {
        return clientFK;
    }

    public void setClientFK(Client clientFK) {
        this.clientFK = clientFK;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
}
