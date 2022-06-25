package com.mygdx.game.model.entities;

import java.util.*;

public class Casa {
	private Tabuleiro tabuleiro;
	private Componente componente;
	
	Casa(Tabuleiro tabuleiro, Componente c) {
		this.setTabuleiro(tabuleiro);
		this.setComponente(c);
	}
	
	// Getters e Setters
	
	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	
	public Componente getComponente() {
		return componente;
	}

	public void setComponente(Componente componente) {
		this.componente = componente;
	}
}
