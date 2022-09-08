package com.MisionTic.ProyectoTienda.repositories;

import com.MisionTic.ProyectoTienda.entities.Employe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepository extends CrudRepository <Employe, Long>{
}
