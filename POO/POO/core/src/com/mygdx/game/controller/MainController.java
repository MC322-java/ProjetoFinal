package com.mygdx.game.controller;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.model.*;
import com.mygdx.game.model.entities.*;
import com.mygdx.game.model.entities.objetos.Chave;
import com.mygdx.game.model.util.*;
import com.mygdx.game.view.MapScreen;

public class MainController {
	
	public static Direcao direcao;
	public static Ataque ataqueInfo;
	
	public static void setPersonagem(int id, int linha, int coluna, int vida, int range, int dano) {
		PersonagemController.setP(id, linha, coluna, vida, range, dano);
	}
	
	public static void move(int linha, int coluna) {
		PersonagemController.move(linha, coluna);
	}
	
	public static int getLinha() {
		return PersonagemController.getLinha();
	}
	
	public static int getColuna() {
		return PersonagemController.getColuna();
	}
	
	public static int getVida() {
		return PersonagemController.getVida();
	}
	
	public static int getDano() {
		return PersonagemController.getDano();
	}
	
	public static int getRange() {
		return PersonagemController.getRange();
	}
	
	public static int getScore() {
		return PersonagemController.getScore();
	}
	
	public static Texture getConfirmationScreen() {
		return PersonagemController.getConfirmationScreen();
	}
	
	public static Texture getImg() {
		return PersonagemController.getImg();
	}
	
	public static Texture imagemAtaque() {
		return PersonagemController.imagemAtaque(direcao);
	}
	
	public static Texture getChaveImg(int i) {
		return PersonagemController.getChaveImg(i);
	}
	
	public static Chave getChave(int i) {
		return PersonagemController.getChave(i);
	}
	
	public static void initTabuleiro() {
		TabuleiroController.tabuleiro = new Tabuleiro();
	}
	
	public static int jogaDado() {
		return Util.jogaDado();
	}
	
	public static void setMensagem(String mensagem) {
		Texto.setMensagem(mensagem);
	}
	
	public static String getMensagem() {
		return Texto.getMensagem();
	}
	
	public static void setDirecao(char ch) {
		if (ch == 'd')
			direcao = Direcao.DIREITA;
		else if (ch == 'e')
			direcao = Direcao.ESQUERDA;
		else if (ch == 'c')
			direcao = Direcao.CIMA;
		else 
			direcao = Direcao.BAIXO;
	}
	
	public static Direcao getDirecao() {
		return direcao;
	}
	
	public static void drawMap(MapScreen mapScreen, int squareSize) {
		TabuleiroController.drawMap(mapScreen, squareSize);
	}
	
	public static void plot(MapScreen mapScreen, Texture t, int squareSize) {
		TabuleiroController.plot(mapScreen, t, PersonagemController.getLinha(), PersonagemController.getColuna(),
				squareSize, squareSize);
	}
	
	public static void atacar(int idx1, int idx2) {
		ataqueInfo = PersonagemController.atacar(direcao, idx1, idx2);
	}
	
	public static Ataque getAtaqueInfo() {
		return ataqueInfo;
	}
	
	public static int getTipoPersonagem() {
		return PersonagemController.getTipo();
	}
	
	public static boolean acertou() {
		return ataqueInfo == Ataque.ACERTOU;
	}
	
	public static boolean vento() {
		return ataqueInfo == Ataque.VENTO;
	}
	
	public static boolean won() {
		return PersonagemController.lastPosition();
	}
	
	public static boolean isDead() {
		return PersonagemController.isDead();
	}
	
	public static ArrayList<Integer> areaAtaque() {
		return PersonagemController.area(direcao);
	}
}
