package com.MisionTic.ProyectoTienda.repositories;

import com.MisionTic.ProyectoTienda.entities.Rol;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends CrudRepository<Rol, Long> {
}
