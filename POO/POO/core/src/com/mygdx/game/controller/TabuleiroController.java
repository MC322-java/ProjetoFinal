package com.mygdx.game.controller;

import com.mygdx.game.model.entities.Tabuleiro;
import com.mygdx.game.view.MapScreen;
import com.badlogic.gdx.graphics.Texture;

public class TabuleiroController {
	
	public static Tabuleiro tabuleiro = new Tabuleiro();
	public static final int SQUARE_SIZE = 20;
	
	public static TabuleiroController getInstance() {
		return new TabuleiroController();
	}
	
	public static void drawMap(MapScreen mapScreen, int squareSize) {
		for (int i = 0; i < 25; i++) {
			for (int j = 0; j < 25; j++) {
				if (tabuleiro.getCasas()[i][j].getComponente() == null)
					continue;
				
				plot(mapScreen, tabuleiro.getCasas()[i][j].getComponente().getImg(), i, j, squareSize, squareSize);
			}
		}
	}
	
	public static void plot(MapScreen mapScreen, Texture img, int linha, int coluna, int squareSize, int tamanho) {
		mapScreen.game.batch.draw(img, (coluna + 14) * squareSize, (26 - linha) * squareSize, tamanho, tamanho);
	}
}
