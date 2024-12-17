package com.tdd.sistema_de_ingressos;

import static org.junit.Assert.*;

import org.junit.Test;

public class LoteTest extends SistemaDeIngressosApplicationTests {

	@Test
	public void testLoteCriacao() {
		Lote lote = new Lote(100, 10, 0.2);
		
		assertEquals(lote.size(), 100, 0);
		assertEquals(lote.sizeMeia(), 10, 0);
		assertEquals(lote.sizeVip(), 20, 0);
		
		assertEquals(lote.precoNormal(), 10, 0);
		assertEquals(lote.precoMeia(), 5, 0);
		assertEquals(lote.precoVip(), 20, 0);
	}
	
	@Test(expected = Exception.class)
	public void testLoteAcimaLimiteVip() {
		Lote lote = new Lote(100, 10, 0.4);
	}
	
	@Test(expected = Exception.class)
	public void testLoteAbaixoLimiteVip() {
		Lote lote = new Lote(100, 10, 0.1);
	}
	
	@Test
	public void testLoteDesconto() {
		Lote lote = new Lote(100, 10, 0.2, 0.2);
		
		assertEquals(lote.precoNormal(), 8, 0);
		assertEquals(lote.precoMeia(), 5, 0);
		assertEquals(lote.precoVip(), 16, 0);
	}
	
	@Test(expected = Exception.class)
	public void testLoteAbaixoLimiteDesconto() {
		Lote lote = new Lote(100, 10, 0.1, -0.1);
	}
	
	@Test(expected = Exception.class)
	public void testLoteAcimaLimiteDesconto() {
		Lote lote = new Lote(100, 10, 0.1, 0.26);
	}
	
	@Test
	public void testVenderIngressos() {
		Lote lote = new Lote(100, 10, 0.2);
		
		assertEquals(lote.size(), 100, 0);
		
		lote.vender(TipoIngresso.NORMAL, 5);
		
		assertEquals(lote.size(), 95, 0);
	}
	
	@Test(expected = Exception.class)
	public void testVenderIngressos() {
		Lote lote = new Lote(100, 10, 0.2);
		
		assertEquals(lote.size(), 100, 0);
		
		lote.vender(TipoIngresso.NORMAL, 105);
	}

}
