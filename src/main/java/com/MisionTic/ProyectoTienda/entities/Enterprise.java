package com.MisionTic.ProyectoTienda.entities;
<<<<<<< HEAD
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
=======

import javax.persistence.*;
import java.io.Serializable;
>>>>>>> 7ef0840803bf44180d380f9fb1da65017a48383e
import java.time.LocalDate;
import java.util.Calendar;

@Entity
@Table(name = "enterprise")
public class Enterprise implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enterprise_id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "document")
    private String document;
    @Column(name = "phone")
    private String phone;
    @Column(name = "aaddress")
    private String address;
    @Column(name = "createdAt")
    private LocalDate createdAt;
    @Column (name = "updatedAt")
    private LocalDate updateAt;

    public Enterprise(){

    }

    public Enterprise(String name, String document, String phone, String address, LocalDate createdAt, LocalDate updateAt) {
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.address = address;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDate updateAt) {
        this.updateAt = updateAt;
    }
}


