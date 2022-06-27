package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.DungeonsAndDragons;
import com.mygdx.game.controller.TabuleiroController;
import com.mygdx.game.model.entities.Tabuleiro;
import com.mygdx.game.model.entities.personagens.Arqueiro;
import com.mygdx.game.model.entities.personagens.Barbaro;
import com.mygdx.game.model.entities.personagens.Guerreiro;
import com.mygdx.game.model.entities.personagens.Mago;

public class SelectionScreen implements Screen {

	public final DungeonsAndDragons game;
	private OrthographicCamera camera;
	private Texture fundo;
	private int lastClick, contador;
	private Mago mago = new Mago(1, 1, 100, 1, 50);
	private Guerreiro guerreiro = new Guerreiro(1, 1, 150, 3, 60);
	private Arqueiro arqueiro = new Arqueiro(1, 1, 90, 25, 50);
	private Barbaro barbaro = new Barbaro(1, 1, 150, 1, 40);
	
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
				game.setScreen(new ConfirmationScreen(game, mago.getTela(), mago));
				dispose();
			} else if (17 * 20 <= Gdx.input.getX() && Gdx.input.getX() <= 25 * 20 && 8 * 20 <= 580 - Gdx.input.getY() && 580 - Gdx.input.getY() <= 17 * 20 && Gdx.input.isTouched()) {
				game.setScreen(new ConfirmationScreen(game, guerreiro.getTela(), guerreiro));
				dispose();
			}else if (28 * 20 <= Gdx.input.getX() && Gdx.input.getX() <= 36 * 20 && 8 * 20 <= 580 - Gdx.input.getY() && 580 - Gdx.input.getY() <= 17 * 20 && Gdx.input.isTouched()) {
				game.setScreen(new ConfirmationScreen(game, arqueiro.getTela(), arqueiro));
				dispose();
			}else if (39 * 20 <= Gdx.input.getX() && Gdx.input.getX() <= 49 * 20 && 8 * 20 <= 580 - Gdx.input.getY() && 580 - Gdx.input.getY() <= 17 * 20 && Gdx.input.isTouched()) {
				game.setScreen(new ConfirmationScreen(game, barbaro.getTela(), barbaro));
				dispose();
			}
			if (51 * 20 <= Gdx.input.getX() && Gdx.input.getX() <= 53 * 20 && 27 * 20 <= 580 - Gdx.input.getY() && 580 - Gdx.input.getY() <= 29 * 20 && Gdx.input.isTouched()) {
				TabuleiroController.tabuleiro = new Tabuleiro();
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
