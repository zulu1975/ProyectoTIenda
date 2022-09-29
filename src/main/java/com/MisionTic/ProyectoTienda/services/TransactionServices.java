package com.MisionTic.ProyectoTienda.services;
import com.MisionTic.ProyectoTienda.Interfaces.ITransactionService;
import com.MisionTic.ProyectoTienda.entities.Transaction;
import com.MisionTic.ProyectoTienda.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServices implements ITransactionService
{
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<Transaction> listas() {return (List<Transaction>) transactionRepository.findAll();
    }

    @Override
    public void guardar(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    @Override
    public Transaction buscarporId(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
       transactionRepository.deleteById(id);
    }

    public float suma(){
            return transactionRepository.sumAmount();

    }
}
