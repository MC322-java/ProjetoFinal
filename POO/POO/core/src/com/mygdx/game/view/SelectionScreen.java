package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.DungeonsAndDragons;
import com.mygdx.game.controller.MainController;

public class SelectionScreen implements Screen {

	public final DungeonsAndDragons game;
	private OrthographicCamera camera;
	private Texture fundo;
	private int lastClick, contador;
	
	SelectionScreen(final DungeonsAndDragons game) {
		this.game = game;
		fundo = new Texture("TelaSelecao.png");
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1060, 580);
		lastClick = contador = 0;
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		ScreenUtils.clear(0, 0, 0.2f, 1);
	    camera.update();
	    game.batch.begin();
		game.batch.setProjectionMatrix(camera.combined);
		game.batch.draw(fundo, 0, 0, 1060, 580);
		if (contador - lastClick >= 10) {
			if (6 * 20 <= Gdx.input.getX() && Gdx.input.getX() <= 14 * 20 && 8 * 20 <= 580 - Gdx.input.getY() && 580 - Gdx.input.getY() <= 17 * 20 && Gdx.input.isTouched()) {
				MainController.setPersonagem(0, 1, 1, 100, 1, 50);
				game.setScreen(new ConfirmationScreen(game));
				dispose();
			} else if (17 * 20 <= Gdx.input.getX() && Gdx.input.getX() <= 25 * 20 && 8 * 20 <= 580 - Gdx.input.getY() && 580 - Gdx.input.getY() <= 17 * 20 && Gdx.input.isTouched()) {
				MainController.setPersonagem(1, 1, 1, 150, 1, 60);
				game.setScreen(new ConfirmationScreen(game));
				dispose();
			}else if (28 * 20 <= Gdx.input.getX() && Gdx.input.getX() <= 36 * 20 && 8 * 20 <= 580 - Gdx.input.getY() && 580 - Gdx.input.getY() <= 17 * 20 && Gdx.input.isTouched()) {
				MainController.setPersonagem(2, 1, 1, 90, 6, 50);
				game.setScreen(new ConfirmationScreen(game));
				dispose();
			}else if (39 * 20 <= Gdx.input.getX() && Gdx.input.getX() <= 49 * 20 && 8 * 20 <= 580 - Gdx.input.getY() && 580 - Gdx.input.getY() <= 17 * 20 && Gdx.input.isTouched()) {
				MainController.setPersonagem(3, 1, 1, 150, 1, 40);
				game.setScreen(new ConfirmationScreen(game));
				dispose();
			}
			if (51 * 20 <= Gdx.input.getX() && Gdx.input.getX() <= 53 * 20 && 27 * 20 <= 580 - Gdx.input.getY() && 580 - Gdx.input.getY() <= 29 * 20 && Gdx.input.isTouched()) {
				MainController.initTabuleiro();
				game.setScreen(new MainMenuScreen(game));
			}
			lastClick = contador;
		}
		contador++;
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
