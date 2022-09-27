package com.MisionTic.ProyectoTienda.repositories;

import com.MisionTic.ProyectoTienda.entities.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends CrudRepository<Profile,Long>
{

}
