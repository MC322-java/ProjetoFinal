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
import com.mygdx.game.model.entities.personagens.Arqueiro;
import com.mygdx.game.model.util.Ataque;
import com.mygdx.game.model.util.Direcao;
import com.mygdx.game.model.util.Util;

public class MapScreen implements Screen {

	
	private static final int TIMER = 7;
	private static final int TIMER_DADO = 100;
	public final DungeonsAndDragons game;
	private Texto texto;
	private OrthographicCamera camera;
	private Texture fundo;
	public static int squareSize;
	private float deltaMovement = 0;
	private int idxD1, idxD2, contadorAtaque, szArqueiro, contador;
	private boolean atacando, firstAttack, acertouDragao;
	private ArrayList<Texture> dadosPlayer, dadosDragao;
	private Direcao direcao;
	int cnt = 0;
	
	public MapScreen(final DungeonsAndDragons game, Personagem p) {
		this.game = game;
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1060, 580);
		fundo = new Texture("TelaFundo.png");
		squareSize = 20;
		texto = new Texto();
		PersonagemController.setP(p);
		dadosPlayer = new ArrayList<Texture>();
		dadosDragao = new ArrayList<Texture>();
		szArqueiro = 0;
		contador = 1;
		firstAttack = true;
		direcao = Direcao.DIREITA;
		for (int i = 1; i <= 20; i++) {
			dadosPlayer.add(new Texture("DadoPlayer/" + i + ".png"));
			dadosDragao.add(new Texture("DadoDragao/" + i + ".png"));
		}
		idxD1 = Util.jogaDado();
		idxD2 = Util.jogaDado();
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
		game.batch.draw(PersonagemController.p.getImg(), 4 * squareSize, 18.5f * squareSize, 6 * squareSize, 6 * squareSize);
		game.batch.draw(dadosPlayer.get(idxD1), 44 * squareSize, 20 * squareSize, 4 * squareSize, 4 * squareSize);
		game.batch.draw(dadosDragao.get(idxD2), 44 * squareSize, 10 * squareSize, 4 * squareSize, 4 * squareSize);
		
		game.font.draw(game.batch, String.valueOf(PersonagemController.p.getVida()), 42.2f * MapScreen.squareSize, 5.8f * MapScreen.squareSize);
		game.font.draw(game.batch, String.valueOf(PersonagemController.p.getDano()), 43.5f * MapScreen.squareSize, 4.75f * MapScreen.squareSize);
		game.font.draw(game.batch, String.valueOf(PersonagemController.p.getRange()), 43f * MapScreen.squareSize, 3.9f * MapScreen.squareSize);
		game.font.draw(game.batch, String.valueOf(PersonagemController.p.getScore()), 42.8f * MapScreen.squareSize, 2.9f * MapScreen.squareSize);
		
		TabuleiroController.drawMap(this, squareSize);
		game.font.draw(game.batch, texto.getMensagem(), 1.5f * MapScreen.squareSize, 3.5f * MapScreen.squareSize);
		if (!atacando) {
			cnt = 0;
			if (deltaMovement >= TIMER) {
				deltaMovement = 0;
				move();
			}
			if (PersonagemController.p.getTipo() == 0 && Gdx.input.isKeyPressed(Keys.A)) {
				atacando = true;
			} else if (PersonagemController.p.getTipo() <= 2 && 
					(Gdx.input.isKeyPressed(Keys.W) || Gdx.input.isKeyPressed(Keys.A) || Gdx.input.isKeyPressed(Keys.S) || Gdx.input.isKeyPressed(Keys.D))) {
				if (Gdx.input.isKeyJustPressed(Keys.W))
					direcao = Direcao.CIMA;
				if (Gdx.input.isKeyJustPressed(Keys.S))
					direcao = Direcao.BAIXO;
				if (Gdx.input.isKeyJustPressed(Keys.A))
					direcao = Direcao.ESQUERDA;
				if (Gdx.input.isKeyJustPressed(Keys.D))
					direcao = Direcao.DIREITA;
				atacando = true;
			}
		} else {
			if ((contador + TIMER_DADO - 1) / TIMER_DADO == 1) {
				idxD1 = Util.jogaDado();
				idxD2 = Util.jogaDado();
				contador++;
			} else if ((contador + TIMER_DADO - 1) / TIMER_DADO == 2) {
				contador++;
				if (PersonagemController.p.getTipo() == 0) {
					if (contadorAtaque == 50) {
						Ataque ataqueInfo = PersonagemController.atacar(Direcao.DIREITA, idxD1, idxD2, texto);
						if (acertouDragao || ataqueInfo == Ataque.ACERTOU) { // > 0
							acertouDragao = true;
						} else if (ataqueInfo == Ataque.VENTO) {
							texto.setMensagem("Voce atacou o vento");
						}
//						atacando = false;
						contadorAtaque = 1;
					} else if (idxD2 <= idxD1){
						ArrayList<Integer> regiao = PersonagemController.area(Direcao.DIREITA);
						for (int i = 1; i <= regiao.get(0); i++) {
							game.batch.draw(PersonagemController.imagemAtaque(Direcao.DIREITA), (14 + regiao.get(i)) * 20, (26 - regiao.get(i + regiao.get(0))) * 20, 20, 20);
						}
						contadorAtaque++;
					} else {
						TabuleiroController.plot(this, new Texture("ataque-dragao.png"), PersonagemController.p.getLinha(), PersonagemController.p.getColuna(),
								squareSize, squareSize);
						contadorAtaque++;
					}
				} else if (PersonagemController.p.getTipo() == 1) {
					if (contadorAtaque == 50) {
						Ataque ataqueInfo = PersonagemController.atacar(direcao, idxD1, idxD2, texto);
						if (acertouDragao || ataqueInfo == Ataque.ACERTOU) {// > 0
							acertouDragao = true;
						} else if (ataqueInfo == Ataque.VENTO) {
//						} else {
							texto.setMensagem("Voce atacou o vento");
						}
//						atacando = false;
						contadorAtaque = 1;
					} else if (idxD2 <= idxD1){
						ArrayList<Integer> regiao = PersonagemController.area(direcao);
						for (int i = 1; i <= regiao.get(0); i++) {
							game.batch.draw(PersonagemController.imagemAtaque(direcao), (14 + regiao.get(i)) * 20, (26 - regiao.get(i + regiao.get(0))) * 20, 20, 20);
						}
						contadorAtaque++;
					} else {
						TabuleiroController.plot(this, new Texture("ataque-dragao.png"), PersonagemController.p.getLinha(), PersonagemController.p.getColuna(),
								squareSize, squareSize);
						contadorAtaque++;
					}
				} else {
					if (contadorAtaque == 50) {
						Ataque ataqueInfo = PersonagemController.atacar(direcao, idxD1, idxD2, texto);
						if (acertouDragao || ataqueInfo == Ataque.ACERTOU) {// > 0
							acertouDragao = true;
						} else if (ataqueInfo == Ataque.VENTO){
							texto.setMensagem("Voce atacou o vento");
						}
//						atacando = false;
						contadorAtaque = 1;
					} else  if (idxD2 <= idxD1) {
						ArrayList<Integer> regiao = PersonagemController.area(direcao);
						int n = (regiao.size() - 1) / 2;
						if (contadorAtaque % 2 == 0 && contadorAtaque / 2 < n) {
							for (int i = 1; i <= regiao.get(0); i++) {
								game.batch.draw(PersonagemController.imagemAtaque(direcao), (14 + regiao.get(contadorAtaque / 2)) * 20, (26 - regiao.get(contadorAtaque / 2 + n)) * 20, 20, 20);
							}
						}
						contadorAtaque++;
					} else {
						TabuleiroController.plot(this, new Texture("ataque-dragao.png"), PersonagemController.p.getLinha(), PersonagemController.p.getColuna(),
								squareSize, squareSize);
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
			if (PersonagemController.p.getChaves()[i] != null) {
				game.batch.draw(PersonagemController.p.getChaves()[i].getImg(), (2 + i) * squareSize, 13 * squareSize, squareSize, squareSize);
			}
		}
		if (51 * 20 <= Gdx.input.getX() && Gdx.input.getX() <= 53 * 20 && 27 * 20 <= 580 - Gdx.input.getY() && 580 - Gdx.input.getY() <= 29 * 20 && Gdx.input.isTouched()) {
			TabuleiroController.tabuleiro = new Tabuleiro();
			game.setScreen(new MainMenuScreen(game));
		}
		if (PersonagemController.lastPosition()) {
			game.setScreen(new YouWinScreen(game));
		}
		if (PersonagemController.p.getVida() <= 0) {
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
			PersonagemController.move(PersonagemController.p.getLinha(), PersonagemController.p.getColuna() - 1, texto);
		if (Gdx.input.isKeyPressed(Keys.RIGHT))
			PersonagemController.move(PersonagemController.p.getLinha(), PersonagemController.p.getColuna() + 1, texto);
		if (Gdx.input.isKeyPressed(Keys.UP))
			PersonagemController.move(PersonagemController.p.getLinha() - 1, PersonagemController.p.getColuna(), texto);
		if (Gdx.input.isKeyPressed(Keys.DOWN))
			PersonagemController.move(PersonagemController.p.getLinha() + 1, PersonagemController.p.getColuna(), texto);
	}
}
