package com.mygdx.game.model.entities;

public abstract class Personagem extends Componente {
	protected int vida;
	// protected int estamina;
	protected int range;
	protected int dano; // talvez mudar o jeito que o dano eh calculado
	
	protected Personagem() {
		super();
	}
	
	protected Personagem(int vida, int range, int dano) {
		super();
		setVida(vida);
		setRange(range);
		setDano(dano);
		
	}
	
	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getDano() {
		return dano;
	}

	public void setDano(int dano) {
		this.dano = dano;
	}

	public abstract void atacar(Tabuleiro tabuleiro);
}
