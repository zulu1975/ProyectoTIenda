package com.MisionTic.ProyectoTienda.Interfaces;

import com.MisionTic.ProyectoTienda.entities.Transaction;

import java.util.List;

public interface ITransactionService
{
    public List<Transaction>listas();

    public void guardar(Transaction transaction);

    public Transaction buscarporId(Long id);

    public  void eliminar(Long id);
}
