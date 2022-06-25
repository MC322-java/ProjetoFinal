package com.mygdx.game.controller;

public class ObjetoController {
	
	public static void removeObject(int linha, int coluna) {
		TabuleiroController.tabuleiro.getBoard()[linha][coluna] = " ";
		TabuleiroController.tabuleiro.getCasas()[linha][coluna].setComponente(null);
	}
	
}
