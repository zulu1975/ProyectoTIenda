package com.MisionTic.ProyectoTienda.entities;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "email")
    private String email;
    @Column(name = "CreatedAt")
    private LocalDate createdAt;
    @Column (name = "UpdatedAt")
    private LocalDate updateAt;

    public Employe(){
    }
    public Employe(long id, String email, LocalDate createdAt, LocalDate updateAt) {
        this.id = id;
        this.email = email;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
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
