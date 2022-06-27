package com.mygdx.game.model.entities;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.model.entities.objetos.Chave;

public abstract class Personagem extends Componente {
	protected int vida;
	// protected int estamina;
	protected int range;
	protected int dano; // talvez mudar o jeito que o dano eh calculado
	protected Chave chaves[] = new Chave[8];
	protected Texture imgDireita, imgEsquerda;
	protected boolean direita;
	
	protected Personagem() {
		super();
		setDireita(true);
	}
	
	protected Personagem(int vida, int range, int dano) {
		super();
		setVida(vida);
		setRange(range);
		setDano(dano);
		setDireita(true);
	}
	
	public void addChave(int idx) {
		chaves[idx] = new Chave(idx);
	}
	
	public void removeChave(int idx) {
		chaves[idx] = null;
	}
	
	public void mudaDirecao() {
		this.setDireita(!this.isDireita());
		if (this.getImg().equals(this.getImgDireita()))
			this.setImg(this.getImgEsquerda());
		else
			this.setImg(this.getImgDireita());
	}
	
	public abstract int atacar();
	
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
	
	public boolean isDireita() {
		return direita;
	}

	public void setDireita(boolean direita) {
		this.direita = direita;
	}

	public Texture getImgDireita() {
		return imgDireita;
	}

	public void setImgDireita(Texture imgDireita) {
		this.imgDireita = imgDireita;
	}

	public Texture getImgEsquerda() {
		return imgEsquerda;
	}

	public void setImgEsquerda(Texture imgEsquerda) {
		this.imgEsquerda = imgEsquerda;
	}
}
