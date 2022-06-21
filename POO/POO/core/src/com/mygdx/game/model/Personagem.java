package com.mygdx.game.model;

public abstract class Personagem extends Componente {
	protected int vida;
	// protected int estamina;
	protected int range;
	protected int dano; // talvez mudar o jeito que o dano eh calculado
	
	public abstract void atacar(Tabuleiro tabuleiro);
}
