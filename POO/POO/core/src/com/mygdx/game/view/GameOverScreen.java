package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.DungeonsAndDragons;
import com.mygdx.game.controller.TabuleiroController;
import com.mygdx.game.model.entities.Tabuleiro;

public class GameOverScreen implements Screen {

	final DungeonsAndDragons game;
	Texture fundo;
	OrthographicCamera camera;
	Viewport viewport;
	
	GameOverScreen(final DungeonsAndDragons game) {
		this.game = game;
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1060,580);
		fundo = new Texture("GameOver.png");
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(0, 0, 0.2f, 1);
		camera.update();
		game.batch.setProjectionMatrix(camera.combined);
		game.batch.begin();
		game.batch.draw(fundo, 0, 0, 1060 ,580);
		if (51 * 20 <= Gdx.input.getX() && Gdx.input.getX() <= 53 * 20 && 27 * 20 <= 580 - Gdx.input.getY() && 580 - Gdx.input.getY() <= 29 * 20 && Gdx.input.isTouched()) {
			TabuleiroController.tabuleiro = new Tabuleiro();
			game.setScreen(new MainMenuScreen(game));
		}
		game.batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
