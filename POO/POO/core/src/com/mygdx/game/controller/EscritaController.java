package com.mygdx.game.controller;

import com.badlogic.gdx.Game;
import com.mygdx.game.view.MapScreen;

public class EscritaController {
	public static void printa(MapScreen mapScreen, String mensagem) {
		mapScreen.game.font.draw(mapScreen.game.batch, mensagem, 1.5f * MapScreen.squareSize, 3.5f * MapScreen.squareSize);
	}
}
