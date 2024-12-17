package com.tdd.sistema_de_ingressos;

public class Ingresso {

  private int id;
	private TipoIngresso tipo;
	private double preco;
	private boolean vendido;
	
	public Ingresso(TipoIngresso tipo, double preco) {
		this.vendido = false;
		this.tipo = tipo;
		
		switch (this.tipo) {
		case MEIA:
			this.preco = preco / 2;
			break;
		case NORMAL:
			this.preco = preco;
			break;
		case VIP:
			this.preco = preco * 2;
			break;
		}
		
		
	}

	public TipoIngresso getTipo() {
		return tipo;
	}

	public void setTipo(TipoIngresso tipo) {
		this.tipo = tipo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public boolean isVendido() {
		return vendido;
	}

	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}
	
}
