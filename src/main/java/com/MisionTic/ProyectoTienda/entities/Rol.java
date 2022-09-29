package com.MisionTic.ProyectoTienda.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "rol")
public class Rol implements Serializable
{
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long id;
     @Column(unique=true)
     private String rol;

     //@Column(unique=true)
     @ManyToOne
     @JoinColumn(name = "user_id")
     private Usuarios user;

     public Rol() {
     }

     public Rol(long id, String rol, Usuarios user) {
          this.id = id;
          this.rol = rol;
          this.user = user;
     }

     public Usuarios getUser() {
          return user;
     }

     public void setUser(Usuarios user) {
          this.user = user;
     }

     public long getId() {
          return id;
     }

     public void setId(long id) {
          this.id = id;
     }

     public String getRol() {
          return rol;
     }

     public void setRol(String rol) {
          this.rol = rol;
     }

     @Override
     public String toString() {
          return "Rol{" +
                  "id=" + id +
                  ", rol='" + rol + '\'' +
                  '}';
     }
}
