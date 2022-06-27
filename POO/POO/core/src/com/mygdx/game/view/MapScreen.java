package com.mygdx.game.view;


import java.util.ArrayList;

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
import com.mygdx.game.model.entities.Tabuleiro;
import com.mygdx.game.model.util.Ataque;
import com.mygdx.game.model.util.Direcao;
import com.mygdx.game.model.util.Util;

public class MapScreen implements Screen {

	
	public final DungeonsAndDragons game;
	private Texto texto;
	private OrthographicCamera camera;
	private Texture fundo;
	public static int squareSize;
	private float deltaMovement = 0;
	private int idxD1, idxD2, contadorAtaque;
	private boolean atacando;
	private ArrayList<Texture> dadosPlayer, dadosDragao;
	
	
	
	public MapScreen(final DungeonsAndDragons game, Personagem p) {
		this.game = game;
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1060, 580);
		fundo = new Texture("TelaFundo.png");
		squareSize = 20;
		texto = new Texto();
		PersonagemController.setP(p);
		dadosPlayer = new ArrayList<Texture>();
		dadosDragao= new ArrayList<Texture>();
		for (int i = 1; i <= 20; i++) {
			dadosPlayer.add(new Texture("DadoPlayer/" + i + ".png"));
			dadosDragao.add(new Texture("DadoDragao/" + i + ".png"));
		}
		idxD1 = idxD2 = 0;
		contadorAtaque = 0;
		atacando = false;
	};
	
	@Override
	public void render(float delta) {
		ScreenUtils.clear(0, 0, 0.2f, 1);
	    camera.update();
	    game.batch.begin();
		game.batch.setProjectionMatrix(camera.combined);
		game.batch.draw(fundo, 0, 0, 1060, 580);
		game.batch.draw(PersonagemController.p.getImg(), 4 * squareSize, 18.5f * squareSize, 6 * squareSize, 6 * squareSize);
		game.batch.draw(dadosDragao.get(idxD1), 44 * squareSize, 10 * squareSize, 4 * squareSize, 4 * squareSize);
		game.batch.draw(dadosPlayer.get(idxD2), 44 * squareSize, 20 * squareSize, 4 * squareSize, 4 * squareSize);
		TabuleiroController.drawMap(this, squareSize);
		game.font.draw(game.batch, texto.getMensagem(), 1.5f * MapScreen.squareSize, 3.5f * MapScreen.squareSize);
		if (!atacando && Gdx.input.isKeyPressed(Keys.A)) {
			atacando = true;
		}
		if (!atacando) {
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
		} else {
			if (contadorAtaque == 10) {
				Ataque ataqueInfo = PersonagemController.atacar(Direcao.DIREITA);
				if (ataqueInfo == Ataque.ACERTOU) // > 0
					texto.setMensagem("Voce acertou um dragao");
				else if (ataqueInfo == Ataque.FALHOU) {
					texto.setMensagem("Seu ataque falhou");
				} else {
					texto.setMensagem("Voce atacou o vento");
				}
				atacando = false;
				contadorAtaque = 0;
			} else {
				pisca(PersonagemController.area());
				idxD1 = Util.jogaDado();
				idxD2 = Util.jogaDado();
				contadorAtaque++;
			}
		}
		deltaMovement++;
		for (int i = 0; i < 8; i++) {
			if (PersonagemController.p.getChaves()[i] != null) {
				game.batch.draw(PersonagemController.p.getChaves()[i].getImg(), (2 + i) * squareSize, 13 * squareSize, squareSize, squareSize);
			}
		}
		if (51 * 20 <= Gdx.input.getX() && Gdx.input.getX() <= 53 * 20 && 27 * 20 <= 580 - Gdx.input.getY() && 580 - Gdx.input.getY() <= 29 * 20 && Gdx.input.isTouched()) {
			TabuleiroController.tabuleiro = new Tabuleiro();
			game.setScreen(new MainMenuScreen(game));
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
