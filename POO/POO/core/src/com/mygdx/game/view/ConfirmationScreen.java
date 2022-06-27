package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.DungeonsAndDragons;
import com.mygdx.game.model.entities.Personagem;
import com.mygdx.game.model.entities.personagens.Arqueiro;
import com.mygdx.game.model.entities.personagens.Barbaro;
import com.mygdx.game.model.entities.personagens.Guerreiro;
import com.mygdx.game.model.entities.personagens.Mago;

public class ConfirmationScreen implements Screen {

	public final DungeonsAndDragons game;
	private OrthographicCamera camera;
	private Texture fundo;
	private int lastClick, contador;
	private Personagem p;
	
	ConfirmationScreen(final DungeonsAndDragons game, Texture t, Personagem p) {
		this.game = game;
		fundo = t;
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1060, 580);
		lastClick = contador = 0;
		this.p = p;
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
			if (43 * 20 <= Gdx.input.getX() && Gdx.input.getX() <= 44 * 20 && 23 * 20 <= 580 - Gdx.input.getY() && 580 - Gdx.input.getY() <= 24 * 20 && Gdx.input.isTouched()) {
				game.setScreen(new SelectionScreen(game));
			}
			if (39 * 20 <= Gdx.input.getX() && Gdx.input.getX() <= 43 * 20 && 6 * 20 <= 580 - Gdx.input.getY() && 580 - Gdx.input.getY() <= 7 * 20 && Gdx.input.isTouched()) {
				game.setScreen(new MapScreen(game, p));
			}
			lastClick = contador;
		}
		contador++;
		game.batch.end();
		dispose();
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
