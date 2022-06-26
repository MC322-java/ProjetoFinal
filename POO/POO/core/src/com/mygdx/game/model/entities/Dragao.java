package com.mygdx.game.model.entities;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.model.util.Util;

public class Dragao extends Componente {
	private int vida;
	private int dano;
	
	public Dragao() {
		this.setImg(new Texture("Dragoes/" + ((Util.jogaDado() % 4) + 1) + ".png"));
	}
	
	public Dragao(int linha, int coluna, int vida, int dano) {
		setLinha(linha);
		setColuna(coluna);
		setVida(vida);
		setDano(dano);
		this.setImg(new Texture("Dragoes/" + ((Util.jogaDado() % 4) + 1) + ".png"));
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
