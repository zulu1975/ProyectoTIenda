package com.MisionTic.ProyectoTienda.entities;

public enum EnumRole {
    ADMINISTRADOR ("Administrador"),
    OPERARIO ("Operario");

    private final String name;
    EnumRole(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
