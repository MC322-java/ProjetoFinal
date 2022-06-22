package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.DungeonsAndDragons;

public class MapScreen implements Screen {

	
	final DungeonsAndDragons game;
	
	OrthographicCamera camera;
	
	public MapScreen(final DungeonsAndDragons game) {
		this.game = game;
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 450);
//		camera.setToOrtho(false, Gdx.graphics.getHeight(), Gdx.graphics.getWidth());
	};
	
	@Override
	public void show() {
		// TODO Auto-generated method stub

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

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		ScreenUtils.clear(0, 0, 0.2f, 1);

//	    camera.setToOrtho(false, 500, 500);
		int squareSize = 15;
	    camera.update();
		game.batch.setProjectionMatrix(camera.combined);

		Texture parede = new Texture("parede.png");
		game.batch.begin();
		for (int i = 0; i < Gdx.graphics.getHeight() / squareSize; i++) {
			for (int j = 0; j < Gdx.graphics.getWidth() / squareSize; j++) {
				game.batch.draw(parede, j * squareSize, i * squareSize, squareSize, squareSize);
			}
		}
		Texture chao = new Texture("chao.jpg");
//		game.batch.draw(chao, squareSize*4, squareSize*4, squareSize, squareSize);
//		game.batch.begin();
		for (int i = 3; i < Math.min(27, Gdx.graphics.getHeight() / squareSize); i++) {
			for (int j = 5; j < Math.min(48, Gdx.graphics.getWidth() / squareSize); j++) {
				game.batch.draw(chao, j * squareSize, i * squareSize, squareSize, squareSize);
			}
		}
		game.batch.end();
		if (Gdx.input.isTouched()) {
			dispose();
		}
	}

}
