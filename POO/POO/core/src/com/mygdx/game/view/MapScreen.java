package com.mygdx.game.view;


import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.DungeonsAndDragons;
import com.mygdx.game.controller.MainController;
//import com.mygdx.game.controller.PersonagemController;

public class MapScreen implements Screen {

	
	private static final int TIMER = 7;
	private static final int TIMER_DADO = 100;
	public final DungeonsAndDragons game;
	private OrthographicCamera camera;
	private Texture fundo;
	public static int squareSize;
	private float deltaMovement = 0;
	private int idxD1, idxD2, contadorAtaque, contador;
	private boolean atacando, acertouDragao;
	private ArrayList<Texture> dadosPlayer, dadosDragao;
	int cnt = 0;
	
	public MapScreen(final DungeonsAndDragons game) {
		this.game = game;
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1060, 580);
		fundo = new Texture("TelaFundo.png");
		squareSize = 20;
		dadosPlayer = new ArrayList<Texture>();
		dadosDragao = new ArrayList<Texture>();
		contador = 1;
		MainController.setDirecao('d');
		for (int i = 1; i <= 20; i++) {
			dadosPlayer.add(new Texture("DadoPlayer/" + i + ".png"));
			dadosDragao.add(new Texture("DadoDragao/" + i + ".png"));
		}
		idxD1 = MainController.jogaDado();
		idxD2 = MainController.jogaDado();
		contadorAtaque = 1;
		atacando = acertouDragao = false;
	};
	
	@Override
	public void render(float delta) {
		ScreenUtils.clear(0, 0, 0.2f, 1);
	    camera.update();
	    game.batch.begin();
		game.batch.setProjectionMatrix(camera.combined);
		game.batch.draw(fundo, 0, 0, 1060, 580);
		game.batch.draw(MainController.getImg(), 4 * squareSize, 18.5f * squareSize, 6 * squareSize, 6 * squareSize);
		game.batch.draw(dadosPlayer.get(idxD1), 44 * squareSize, 20 * squareSize, 4 * squareSize, 4 * squareSize);
		game.batch.draw(dadosDragao.get(idxD2), 44 * squareSize, 10 * squareSize, 4 * squareSize, 4 * squareSize);
		
		game.font.draw(game.batch, String.valueOf(MainController.getVida()), 42.2f * MapScreen.squareSize, 5.8f * MapScreen.squareSize);
		game.font.draw(game.batch, String.valueOf(MainController.getDano()), 43.5f * MapScreen.squareSize, 4.75f * MapScreen.squareSize);
		game.font.draw(game.batch, String.valueOf(MainController.getRange()), 43f * MapScreen.squareSize, 3.9f * MapScreen.squareSize);
		game.font.draw(game.batch, String.valueOf(MainController.getScore()), 42.8f * MapScreen.squareSize, 2.9f * MapScreen.squareSize);
		MainController.drawMap(this, squareSize);
		game.font.draw(game.batch, MainController.getMensagem(), 1.5f * MapScreen.squareSize, 3.5f * MapScreen.squareSize);
		if (!atacando) {
			cnt = 0;
			if (deltaMovement >= TIMER) {
				deltaMovement = 0;
				move();
			}
			if (MainController.getTipoPersonagem() == 0 && Gdx.input.isKeyPressed(Keys.A)) {
				atacando = true;
			} else if (MainController.getTipoPersonagem() <= 2 && 
					(Gdx.input.isKeyPressed(Keys.W) || Gdx.input.isKeyPressed(Keys.A) || Gdx.input.isKeyPressed(Keys.S) || Gdx.input.isKeyPressed(Keys.D))) {
				if (Gdx.input.isKeyJustPressed(Keys.W))
					MainController.setDirecao('c');
				if (Gdx.input.isKeyJustPressed(Keys.S))
					MainController.setDirecao('b');
				if (Gdx.input.isKeyJustPressed(Keys.A))
					MainController.setDirecao('e');
				if (Gdx.input.isKeyJustPressed(Keys.D))
					MainController.setDirecao('d');
				atacando = true;
			}
		} else {
			if ((contador + TIMER_DADO - 1) / TIMER_DADO == 1) {
				idxD1 = MainController.jogaDado();
				idxD2 = MainController.jogaDado();
				contador++;
			} else if ((contador + TIMER_DADO - 1) / TIMER_DADO == 2) {
				contador++;
				if (MainController.getTipoPersonagem() == 0) {
					if (contadorAtaque == 50) {
						MainController.atacar(idxD1, idxD2);
						if (acertouDragao || MainController.acertou()) { // > 0
							acertouDragao = true;
						} else if (MainController.vento()) {
							MainController.setMensagem("Voce atacou o vento");
						}
//						atacando = false;
						contadorAtaque = 1;
					} else if (idxD2 <= idxD1){
						ArrayList<Integer> regiao = MainController.areaAtaque();
						for (int i = 1; i <= regiao.get(0); i++) {
							game.batch.draw(MainController.imagemAtaque(), (14 + regiao.get(i)) * 20, (26 - regiao.get(i + regiao.get(0))) * 20, 20, 20);
						}
						contadorAtaque++;
					} else {
						MainController.plot(this, new Texture("ataque-dragao.png"), squareSize);
						contadorAtaque++;
					}
				} else if (MainController.getTipoPersonagem() == 1) {
					if (contadorAtaque == 50) {
						MainController.atacar(idxD1, idxD2);
						if (acertouDragao || MainController.acertou()) {// > 0
							acertouDragao = true;
						} else if (MainController.vento()) {
//						} else {
							MainController.setMensagem("Voce atacou o vento");
						}
//						atacando = false;
						contadorAtaque = 1;
					} else if (idxD2 <= idxD1){
						ArrayList<Integer> regiao = MainController.areaAtaque();
						for (int i = 1; i <= regiao.get(0); i++) {
							game.batch.draw(MainController.imagemAtaque(), (14 + regiao.get(i)) * 20, (26 - regiao.get(i + regiao.get(0))) * 20, 20, 20);
						}
						contadorAtaque++;
					} else {
						MainController.plot(this, new Texture("ataque-dragao.png"), squareSize);
						contadorAtaque++;
					}
				} else {
					if (contadorAtaque == 50) {
						MainController.atacar(idxD1, idxD2);
						if (acertouDragao || MainController.acertou()) {// > 0
							acertouDragao = true;
						} else if (MainController.vento()) {
							MainController.setMensagem("Voce atacou o vento");
						}
						contadorAtaque = 1;
					} else  if (idxD2 <= idxD1) {
						ArrayList<Integer> regiao = MainController.areaAtaque();
						int n = (regiao.size() - 1) / 2;
						if (contadorAtaque % 2 == 0 && contadorAtaque / 2 < n) {
							for (int i = 1; i <= regiao.get(0); i++) {
								game.batch.draw(MainController.imagemAtaque(), (14 + regiao.get(i)) * 20, (26 - regiao.get(i + regiao.get(0))) * 20, 20, 20);
							}
						}
						contadorAtaque++;
					} else {
						MainController.plot(this, new Texture("ataque-dragao.png"), squareSize);
						contadorAtaque++;
					}
				}
				contador++;
			} else if ((contador + TIMER_DADO - 1) / TIMER_DADO == 3) {
				acertouDragao = false;
				atacando = false;
				contador = 1;
			}
		}
		deltaMovement++;
		for (int i = 0; i < 8; i++) {
			if (MainController.getChave(i) != null) {
				game.batch.draw(MainController.getChaveImg(i), (2 + i) * squareSize, 13 * squareSize, squareSize, squareSize);
			}
		}
		if (51 * 20 <= Gdx.input.getX() && Gdx.input.getX() <= 53 * 20 && 27 * 20 <= 580 - Gdx.input.getY() && 580 - Gdx.input.getY() <= 29 * 20 && Gdx.input.isTouched()) {
			MainController.initTabuleiro();
			game.setScreen(new MainMenuScreen(game));
		}
		if (MainController.won()) {
			game.setScreen(new YouWinScreen(game));
		}
		if (MainController.isDead()) {
			game.setScreen(new GameOverScreen(game));
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
	
	public void move() {
		if (Gdx.input.isKeyPressed(Keys.LEFT))
			MainController.move(MainController.getLinha(), MainController.getColuna() - 1);
		if (Gdx.input.isKeyPressed(Keys.RIGHT))
			MainController.move(MainController.getLinha(), MainController.getColuna() + 1);
		if (Gdx.input.isKeyPressed(Keys.UP))
			MainController.move(MainController.getLinha() - 1, MainController.getColuna());
		if (Gdx.input.isKeyPressed(Keys.DOWN))
			MainController.move(MainController.getLinha() + 1, MainController.getColuna());
	}
}
