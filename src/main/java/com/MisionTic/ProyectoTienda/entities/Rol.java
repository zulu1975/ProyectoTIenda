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

     private String usuarios_id;

     private String rol;

     @OneToMany(mappedBy = "id")
     private List<Usuarios> usuarioss;

     public Rol() {
     }

     public Rol(long id, String usuarios_id, String rol, List<Usuarios> usuarioss) {
          this.id = id;
          this.usuarios_id = usuarios_id;
          this.rol = rol;
          this.usuarioss = usuarioss;
     }

     public long getId() {
          return id;
     }

     public void setId(long id) {
          this.id = id;
     }

     public String getUsuarios_id() {
          return usuarios_id;
     }

     public void setUsuarios_id(String usuarios_id) {
          this.usuarios_id = usuarios_id;
     }

     public String getRol() {
          return rol;
     }

     public void setRol(String rol) {
          this.rol = rol;
     }

     public List<Usuarios> getUsuarioss() {
          return usuarioss;
     }

     public void setUsuarioss(List<Usuarios> usuarioss) {
          this.usuarioss = usuarioss;
     }

     @Override
     public String toString() {
          return "Rol{" +
                  "id=" + id +
                  ", usuarios_id='" + usuarios_id + '\'' +
                  ", rol='" + rol + '\'' +
                  '}';
     }
}
