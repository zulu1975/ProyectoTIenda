package com.MisionTic.ProyectoTienda.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name="Usuarios")
public class Usuarios implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (columnDefinition = "integer default 1")
    private Integer estado;

    private String username;

    private String password;

    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;


    public Usuarios() {
    }

    public Usuarios(long id, Integer estado, String username, String password, Rol rol) {
        this.id = id;
        this.estado = estado;
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "id=" + id +
                ", estado=" + estado +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
