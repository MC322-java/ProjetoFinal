package com.mygdx.game.model.entities;

import java.util.*;

public class Casa {
	private Tabuleiro tabuleiro;
	private ArrayList<Componente> componentes;
	
	Casa(Tabuleiro tabuleiro, Componente c) {
		this.setTabuleiro(tabuleiro);
		this.componentes = new ArrayList<Componente>();
		componentes.add(c);
	}

	public void adicionaComponente(Componente c) {
		componentes.add(c);
	}
	
	// Getters e Setters
	
	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	
	public ArrayList<Componente> getComponentes() {
		return componentes;
	}

	public void setComponentes(ArrayList<Componente> componentes) {
		this.componentes = componentes;
	}
}
