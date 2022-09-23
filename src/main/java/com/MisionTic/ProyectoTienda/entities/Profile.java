package com.MisionTic.ProyectoTienda.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "profile")
public class Profile
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String image;
    private String phone;
    private LocalDate createdAt=LocalDate.now();
    private LocalDate updatedAt=LocalDate.now();

    // Relaciones con entidades

    //@OneToOne(mappedBy = "id")
    //private Employe employe;

    public Profile()
    {

    }

    public Profile(long id, String image, String phone, LocalDate createdAt, LocalDate updatedAt) {
        this.id = id;
        this.image = image;
        this.phone = phone;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", phone='" + phone + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
