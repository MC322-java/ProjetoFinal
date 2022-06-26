package com.mygdx.game.view;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.DungeonsAndDragons;
import com.mygdx.game.controller.PersonagemController;
import com.mygdx.game.controller.TabuleiroController;
import com.mygdx.game.model.Texto;
import com.mygdx.game.model.entities.Personagem;

public class MapScreen implements Screen {

	
	public final DungeonsAndDragons game;
	private Texto texto;
	private OrthographicCamera camera;
	private Texture fundo, player;
	public static int squareSize;
	float deltaMovement = 0;
	
	
	
	public MapScreen(final DungeonsAndDragons game, Personagem p) {
		this.game = game;
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1060, 580);
		fundo = new Texture("TelaFundo.png");
		squareSize = 20;
		texto = new Texto();
		PersonagemController.p = p;
		player = p.getImg();
	};
	
	@Override
	public void render(float delta) {
		ScreenUtils.clear(0, 0, 0.2f, 1);
	    camera.update();
	    game.batch.begin();
		game.batch.setProjectionMatrix(camera.combined);
		game.batch.draw(fundo, 0, 0, 1060, 580);
		game.batch.draw(player, 4 * squareSize, 18.5f * squareSize, 6 * squareSize, 6 * squareSize);
		TabuleiroController.drawMap(this, squareSize);
		game.font.draw(game.batch, texto.getMensagem(), 1.5f * MapScreen.squareSize, 3.5f * MapScreen.squareSize);
		if (deltaMovement >= 5) {
			deltaMovement = 0;
			if (Gdx.input.isKeyPressed(Keys.LEFT))
				PersonagemController.move(PersonagemController.p.getLinha(), PersonagemController.p.getColuna() - 1);
			if (Gdx.input.isKeyPressed(Keys.RIGHT))
				PersonagemController.move(PersonagemController.p.getLinha(), PersonagemController.p.getColuna() + 1);
			if (Gdx.input.isKeyPressed(Keys.UP))
				PersonagemController.move(PersonagemController.p.getLinha() - 1, PersonagemController.p.getColuna());
			if (Gdx.input.isKeyPressed(Keys.DOWN))
				PersonagemController.move(PersonagemController.p.getLinha() + 1, PersonagemController.p.getColuna());
			if (Gdx.input.isKeyPressed(Keys.A)) {
				int ataqueInfo = PersonagemController.atacar();
				if (ataqueInfo > 0) // > 0
					texto.setMensagem("Voce matou um dragao");
				else if (ataqueInfo == 0) {
					texto.setMensagem("Seu ataque falhou");
				} else {
					texto.setMensagem("Voce atacou o vento");
				}
			}
		}
		deltaMovement++;
		for (int i = 0; i < 8; i++) {
			if (PersonagemController.p.getChaves()[i] != null) {
				game.batch.draw(PersonagemController.p.getChaves()[i].getImg(), (2 + i) * squareSize, 13 * squareSize, squareSize, squareSize);
			}
		}
		camera.update();
		game.batch.end();
		dispose();
	}

	@Override
	public void show() {
		
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void dispose() {
	}

	
}
