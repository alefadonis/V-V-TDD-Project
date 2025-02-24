package com.tdd.processador_de_contas.repository;

import com.tdd.processador_de_contas.models.Fatura;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class FaturaRepository {

    private final HashMap<LocalDate ,Fatura> faturaDB;

    public FaturaRepository(){
        faturaDB = new HashMap();
    }

    public void createFatura(String clientName, LocalDate date, Float totalValue){
        Fatura newFatura = new Fatura(clientName, date, totalValue);

        faturaDB.put(date, newFatura);
    }

    public Fatura[] getAll() {
        ArrayList<Fatura> faturas = new ArrayList<>(faturaDB.values());

        return faturas.isEmpty() ? new Fatura[0] : faturas.toArray(new Fatura[0]);
    }
}
