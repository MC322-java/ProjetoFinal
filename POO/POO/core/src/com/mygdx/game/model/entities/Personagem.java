package com.mygdx.game.model.entities;

import java.util.ArrayList;

import com.mygdx.game.model.entities.objetos.Chave;

public abstract class Personagem extends Componente {
	protected int vida;
	// protected int estamina;
	protected int range;
	protected int dano; // talvez mudar o jeito que o dano eh calculado
	protected Chave chaves[] = new Chave[8];
	
	protected Personagem() {
		super();
	}
	
	protected Personagem(int vida, int range, int dano) {
		super();
		setVida(vida);
		setRange(range);
		setDano(dano);
	}
	
	public void addChave(int idx) {
		chaves[idx] = new Chave(idx);
	}
	
	public void removeChave(int idx) {
		chaves[idx] = null;
	}
	
	public abstract void atacar(Tabuleiro tabuleiro);
	
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

	public Chave[] getChaves() {
		return chaves;
	}

	public void setChaves(Chave[] chaves) {
		this.chaves = chaves;
	}
	
}
