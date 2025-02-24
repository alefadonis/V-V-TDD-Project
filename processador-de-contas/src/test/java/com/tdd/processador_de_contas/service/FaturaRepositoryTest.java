package com.tdd.processador_de_contas.service;

import com.tdd.processador_de_contas.models.Fatura;
import com.tdd.processador_de_contas.repository.FaturaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;


@SpringBootTest
public class FaturaRepositoryTest {

    private FaturaRepository faturaRepository = new FaturaRepository();

    public void createFatura(){
        this.faturaRepository.createFatura(
                "José Pereira", LocalDate.of(2024,10,10), 100.0F);
    }

    @Test
    public void checkIfFaturaExists() throws Exception {
        this.createFatura();

        Fatura[] faturaCreated = faturaRepository.getAll();

        if(faturaCreated.length > 1){
            throw new Exception("Fatura Already there");
        }

        Assertions.assertTrue(faturaCreated[0] instanceof Fatura);
    }

}
