package com.mygdx.game.model.entities;

public class Componente {
	protected int linha;
	protected int coluna;
	
	Componente() {}
	
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
}
