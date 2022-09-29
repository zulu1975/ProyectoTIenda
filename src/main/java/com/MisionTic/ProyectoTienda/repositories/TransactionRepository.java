package com.MisionTic.ProyectoTienda.repositories;
import com.MisionTic.ProyectoTienda.entities.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction,Long>
{
    @Query(value = "SELECT SUM(amount) total FROM transaction", nativeQuery = true)
    float sumAmount();
}
