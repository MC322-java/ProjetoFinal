package com.mygdx.game;


import com.mygdx.game.model.entities.Tabuleiro;
import com.mygdx.game.view.MainMenuScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class DungeonsAndDragons extends Game {

	public SpriteBatch batch;
	public BitmapFont font;
	public Tabuleiro tabuleiro;

	@Override
	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont(); // use libGDX's default Arial font
		tabuleiro = new Tabuleiro();
		this.setScreen(new MainMenuScreen(this));
	}

	public void render() {
		super.render(); // important!
	}

	@Override
	public void dispose() {
		batch.dispose();
		font.dispose();
	}

}
