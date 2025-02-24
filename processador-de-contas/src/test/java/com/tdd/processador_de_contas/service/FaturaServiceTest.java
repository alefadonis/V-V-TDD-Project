package com.tdd.processador_de_contas.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class FaturaServiceTest {

    @Autowired
    private FaturaRepository faturaRepository;

    public void createFatura(){
        this.faturaRepository.create("2024-10-10", "100", "José Pereira");
    }

    @Test
    public void checkIfFaturaExists() throws Exception {
        this.createFatura();

        Fatura [] faturaCreated = faturaRepository.getAll();

        if(faturaCreated.length > 1){
            throw new Exception("Fatura Already there");
        }

        Assertions.assertTrue(faturaCreated[0] instanceof Fatura);
    }

}
