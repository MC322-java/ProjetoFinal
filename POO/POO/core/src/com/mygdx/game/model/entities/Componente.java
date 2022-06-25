package com.mygdx.game.model.entities;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.controller.TabuleiroController;

public class Componente {
	protected int linha;
	protected int coluna;
	private Texture img;
	
	Componente() {}
	
	Componente(Texture img) {
		setImg(img);
	}
	
	Componente(int linha, int coluna) {
		setLinha(linha);
		setColuna(coluna);
	}

	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

	public Texture getImg() {
		return img;
	}

	public void setImg(Texture img) {
		this.img = img;
	}
}
