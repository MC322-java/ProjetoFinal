package com.mygdx.game.model.entities;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.DungeonsAndDragons;
import com.mygdx.game.model.Texto;
import com.mygdx.game.model.entities.objetos.Chave;
import com.mygdx.game.model.util.Ataque;
import com.mygdx.game.model.util.Direcao;

public abstract class Personagem extends Componente {
	protected int vida;
	// protected int estamina;
	protected int range;
	protected int dano; // talvez mudar o jeito que o dano eh calculado
	protected int tipo;
	protected Direcao direcao;
	protected Chave chaves[] = new Chave[8];
	protected Texture imgDireita, imgEsquerda;
	private Texture tela;
	protected String nome;
	protected boolean direita;
	protected int Score;
	
	protected Personagem() {
		super();
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
	
	public void setTela() {
		tela = new Texture(this.nome + "Tela.png");
	}
	
	public abstract ArrayList<Integer> area(Direcao direcao);
	
	public abstract Ataque atacar(Direcao direcao, int dadoPlayer, int dadoDragoes, Texto texto);
	
	public abstract Texture getAtaque(Direcao direcao);
	
	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getRange() {
		return range;
	}

	public abstract void setRange(int range);

	public int getDano() {
		return dano;
	}

	public void setDano(int dano) {
		this.dano = dano;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
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

	public Texture getTela() {
		return tela;
	}

	public void setTela(Texture tela) {
		this.tela = tela;
	}

	public int getScore() {
		// TODO Auto-generated method stub
		return this.Score;
	}

	public void setScore(int Score) {
		this.Score = Score;
		
	}
}
