package com.mygdx.game.model.entities;

public class Dragao extends Componente {
	private int vida;
	private int dano;
	
	public Dragao() {}
	
	public Dragao(int vida, int dano) {
		setVida(vida);
		setDano(dano);
	}
	// fazer um metodo pra gerar a pontuacao recebida pelo player ao morrer
	
	// Getters e Setters
	
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getDano() {
		return dano;
	}
	public void setDano(int dano) {
		this.dano = dano;
	}
}