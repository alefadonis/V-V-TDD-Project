package com.tdd.sistema_de_ingressos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Lote {
	private int id;
	private int quantidade;
	private double preco;
	private ArrayList<Ingresso> ingressos;
	private double vip = 0.2;
	private double desconto = 0;
	
	public Lote(int quantidade, double preco) {
		this.quantidade = quantidade;
		this.preco = preco;
		
		this.ingressos = new ArrayList<Ingresso>(this.quantidade);
		for (int i = 0; i <= 0.1 * quantidade; i++) {
			ingressos.add(new Ingresso(TipoIngresso.MEIA, preco));
		}
		for (int i = 0; i <= this.vip * quantidade; i++) {
			ingressos.add(new Ingresso(TipoIngresso.VIP, preco));
		}
		for (int i = 0; i <= this.quantidade - (0.1 * quantidade + this.vip * quantidade); i++) {
			ingressos.add(new Ingresso(TipoIngresso.VIP, preco));
		}
	}
	
	public Lote(int quantidade, double preco, double vip) {
		this.quantidade = quantidade;
		this.preco = preco;
		this.vip = vip;
		
		this.ingressos = new ArrayList<Ingresso>(this.quantidade);
		for (int i = 0; i <= 0.1 * quantidade; i++) {
			ingressos.add(new Ingresso(TipoIngresso.MEIA, preco));
		}
		for (int i = 0; i <= this.vip * quantidade; i++) {
			ingressos.add(new Ingresso(TipoIngresso.VIP, preco));
		}
		for (int i = 0; i <= this.quantidade - (0.1 * quantidade + this.vip * quantidade); i++) {
			ingressos.add(new Ingresso(TipoIngresso.VIP, preco));
		}
	}
	
	public Lote(int quantidade, double preco, double vip, double desconto) {
		this.quantidade = quantidade;
		this.preco = preco;
		this.vip = vip;
		this.desconto = desconto;
		
		this.ingressos = new ArrayList<Ingresso>(this.quantidade);
		for (int i = 0; i <= 0.1 * quantidade; i++) {
			ingressos.add(new Ingresso(TipoIngresso.MEIA, this.preco()));
		}
		for (int i = 0; i <= this.vip * quantidade; i++) {
			ingressos.add(new Ingresso(TipoIngresso.VIP, this.preco() - this.preco()*this.desconto));
		}
		for (int i = 0; i < this.quantidade - (0.1 * quantidade + this.vip * quantidade); i++) {
			ingressos.add(new Ingresso(TipoIngresso.VIP, this.preco() - this.preco()*this.desconto));
		}
	}
	
	public List<Ingresso> vender(TipoIngresso tipo, int quantidade) {
		Stream<Ingresso> stream = this.ingressos.stream().filter(ingresso -> ingresso.getTipo() == tipo && !ingresso.isVendido()).limit(5);
		stream.forEach(ingresso -> ingresso.setVendido(true));
		List<Ingresso> ingressos = stream.toList();
		return ingressos;
	}
	
	public double preco() {
		return this.preco();
	}
	
	public double precoMeia() {
		return this.preco() / 2;
	}
	
	public double precoNormal() {
		return this.preco() - this.preco() * this.desconto;
	}
	
	public double precoVip() {
		return 2 * (this.preco() - this.preco() * this.desconto);
	}
	
	public int size() {
		return this.ingressos.size();
	}
	
	public int sizeVip() {
		return this.ingressos.stream().filter(ingresso -> ingresso.getTipo() == TipoIngresso.VIP).toList().size();
	}
	
	public int sizeNormal() {
		return this.ingressos.stream().filter(ingresso -> ingresso.getTipo() == TipoIngresso.NORMAL).toList().size();
	}
	
	public int sizeMeia() {
		return this.ingressos.stream().filter(ingresso -> ingresso.getTipo() == TipoIngresso.MEIA).toList().size();
	}
}
