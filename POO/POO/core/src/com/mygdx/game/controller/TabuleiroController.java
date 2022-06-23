package com.mygdx.game.controller;

import com.mygdx.game.model.entities.Tabuleiro;
import com.mygdx.game.view.MapScreen;
import com.badlogic.gdx.graphics.Texture;

public class TabuleiroController {
	Tabuleiro tabuleiro = new Tabuleiro();
	
	TabuleiroController() {
		
	}
	
	public static TabuleiroController getInstance() {
		return new TabuleiroController();
	}
	
	public void drawMap(MapScreen mapScreen, int squareSize) {
		for (int i = 0; i < 25; i++) {
			for (int j = 0; j < 25; j++) {
				if (this.tabuleiro.getBoard()[i][j] == 'p') {
					plot(mapScreen, "parede", i, j, squareSize);
				}
			}
		}
		plot(mapScreen, "mago", 1, 1, squareSize);
		plot(mapScreen, "dragao", 3, 1, squareSize);
	}
	
	private void plot(MapScreen mapScreen, String img, int linha, int coluna, int squareSize) {
		mapScreen.game.batch.draw(new Texture(img + ".png"), (coluna + 14) * squareSize, (26 - linha) * squareSize, squareSize, squareSize);
	}
}
