package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.DungeonsAndDragons;
import com.mygdx.game.controller.TabuleiroController;
import com.mygdx.game.model.entities.Tabuleiro;
import com.mygdx.game.model.entities.personagens.Guerreiro;
import com.mygdx.game.model.entities.personagens.Mago;

public class SelectionScreen implements Screen {

	public final DungeonsAndDragons game;
	
	private OrthographicCamera camera;
	private Texture parede = new Texture("parede.png");
	private Texture chao = new Texture("chao.png");
	private Texture mago = new Texture("mago.png");
	private Texture guerreiro = new Texture("guerreiro.png");
	private Texture arqueiro = new Texture("mago.png");
	
	SelectionScreen(final DungeonsAndDragons game) {
		this.game = game;
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1060, 580);
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
		for (int i = 0; i < Gdx.graphics.getWidth() / 20; i++) {
			for (int j = 0; j < Gdx.graphics.getHeight() / 20; j++) {
				game.batch.draw(parede, i * TabuleiroController.SQUARE_SIZE, j * TabuleiroController.SQUARE_SIZE, TabuleiroController.SQUARE_SIZE, TabuleiroController.SQUARE_SIZE);
			}
		}
		for (int i = 10; i <= 15; i++) {
			for (int j = 10; j <= 15; j++) {
				game.batch.draw(chao, i * 20, j * 20, 20, 20);
			}
		}
		game.batch.draw(mago, 10 * 20, 10 * 20, 20 * 6, 20 * 6);
		for (int i = 19; i <= 24; i++) {
			for (int j = 10; j <= 15; j++) {
				game.batch.draw(chao, i * 20, j * 20, 20, 20);
			}
		}
		game.batch.draw(guerreiro, 19 * 20, 10 * 20, 20 * 6, 20 * 6);
		if (10 * 20 <= Gdx.input.getX() && Gdx.input.getX() <= 16 * 20 && 10 * 20 <= 580 - Gdx.input.getY() && 580 - Gdx.input.getY() <= 16 * 20 && Gdx.input.isTouched()) {
			// Mago(linha, coluna, vida, range, dano)
			game.setScreen(new MapScreen(game, new Mago(1, 1, 1, 1, 1)));
			dispose();
		} else if (19 * 20 <= Gdx.input.getX() && Gdx.input.getX() <= 25 * 20 && 10 * 20 <= 580 - Gdx.input.getY() && 580 - Gdx.input.getY() <= 16 * 20 && Gdx.input.isTouched()) {
			game.setScreen(new MapScreen(game, new Guerreiro(1, 1, 1, 1, 1)));
			dispose();
		}
		game.batch.end();
//		dispose();
//		game.batch.end();
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
