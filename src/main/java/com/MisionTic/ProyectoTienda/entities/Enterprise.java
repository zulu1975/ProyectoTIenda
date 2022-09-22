package com.MisionTic.ProyectoTienda.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "enterprise")
public class Enterprise implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String document;
    private String phone;
    private String address;

    private LocalDate createdAt=LocalDate.now();

    private LocalDate updateAt=LocalDate.now();

    public Enterprise(){}

    public Enterprise(long id, String name, String document, String phone, String address, LocalDate createdAt, LocalDate updateAt) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.address = address;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

}
