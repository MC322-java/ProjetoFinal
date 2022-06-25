package com.mygdx.game.view;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.DungeonsAndDragons;
import com.mygdx.game.controller.EscritaController;
import com.mygdx.game.controller.PersonagemController;
import com.mygdx.game.controller.TabuleiroController;
import com.mygdx.game.model.entities.Personagem;
import com.mygdx.game.model.util.Util;
;

public class MapScreen implements Screen {

	
	public final DungeonsAndDragons game;
	
	private OrthographicCamera camera;
	private Texture fundo, player;
//	private Rectangle player;
	public static int squareSize;
	float deltaMovement = 0;
	
	
	
	public MapScreen(final DungeonsAndDragons game, Personagem p) {
		this.game = game;
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1060, 580);
		fundo = new Texture("TelaFundo.png");
		squareSize = 20;
		PersonagemController.p = p;
//		TabuleiroController.tabuleiro.getCasas()[p.getLinha()][p.getColuna()].setComponente(p);
		player = p.getImg();
//		player = new Rectangle();
//		player.x = 15*squareSize; // center the bucket horizontally
//		player.y = 25*squareSize; // bottom left corner of the bucket is 20 pixels above
//						// the bottom screen edge
//		player.width = squareSize;
//		player.height = squareSize;
	};
	
	@Override
	public void render(float delta) {
		ScreenUtils.clear(0, 0, 0.2f, 1);
	    camera.update();
	    game.batch.begin();
		game.batch.setProjectionMatrix(camera.combined);
		game.batch.draw(fundo, 0, 0, 1060, 580);
//		game.batch.draw(PersonagemController.p.getImg(), 4 * squareSize, 18.5f * squareSize, 6 * squareSize, 6 * squareSize);
		game.batch.draw(player, 4 * squareSize, 18.5f * squareSize, 6 * squareSize, 6 * squareSize);
//		int dadoPlayer = Util.jogaDado();
		TabuleiroController.drawMap(this, squareSize);
		if (Gdx.input.isKeyPressed(Keys.A)) {
			EscritaController.printa(this, "Voce recebeu 100 de dano");
//			PersonagemController.atacar();
		}
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
//		camera.update();
//		game.batch.begin();
//		game.batch.draw(new Texture("TelaFundo.png"), 0, 0, 1060, 580);
//		game.batch.draw(new Texture("mago.png"), 4 * 20, 18 * 20, 6 * 20, 6 * 20);
//		game.batch.end();
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
