package com.MisionTic.ProyectoTienda.repositories;
import com.MisionTic.ProyectoTienda.entities.Enterprise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepository extends CrudRepository<Enterprise, Long> {
}
