package com.MisionTic.ProyectoTienda.repositories;
import com.MisionTic.ProyectoTienda.entities.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction,Long>
{

}
