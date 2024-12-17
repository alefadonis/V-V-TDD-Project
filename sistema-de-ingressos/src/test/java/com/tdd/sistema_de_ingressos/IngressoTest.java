package com.tdd.sistema_de_ingressos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IngressoTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
    public void testCriarIngressoNormal() {
        Ingresso ingressoNormal = new Ingresso(TipoIngresso.NORMAL, 10.0);

        assertEquals(10.0, ingressoNormal.getPreco(), 0);
        assertEquals(TipoIngresso.NORMAL, ingressoNormal.getTipo());
        assertFalse(ingressoNormal.isVendido());
    }

    @Test
    public void testCriarIngressoVIP() {
        Ingresso ingressoVip = new Ingresso(TipoIngresso.VIP, 10.0);

        assertEquals(20.0, ingressoVip.getPreco(), 0);
        assertEquals(TipoIngresso.VIP, ingressoVip.getTipo());
        assertFalse(ingressoVip.isVendido());
    }

    @Test
    public void testCriarIngressoMeia() {
        Ingresso ingressoMeia = new Ingresso(TipoIngresso.MEIA, 10.0);

        assertEquals(5.0, ingressoMeia.getPreco(), 0);
        assertEquals(TipoIngresso.MEIA, ingressoMeia.getTipo());
        assertFalse(ingressoMeia.isVendido());
    }

}
