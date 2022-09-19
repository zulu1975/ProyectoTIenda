package com.MisionTic.ProyectoTienda.entities;
import org.springframework.context.annotation.Profile;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employe")
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employe_id")
    private long id;
    private String email;
    @Column(name = "created_at")
    private LocalDate createdAt;

     @Column (name = "updated_at")
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
