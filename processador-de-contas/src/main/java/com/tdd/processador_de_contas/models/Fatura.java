package com.tdd.processador_de_contas.models;

import java.time.LocalDate;

public class Fatura {

    private String clientName;
    private LocalDate date;
    private Float totalValue;
    private String paid;

    public Fatura(String clientName, LocalDate date, Float totalValue){
        this.clientName = clientName;
        this.date = date;
        this.totalValue = totalValue;
        this.paid = "PENDENTE";
    }
}
