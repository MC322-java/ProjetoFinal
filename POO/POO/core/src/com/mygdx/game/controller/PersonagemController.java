package com.mygdx.game.controller;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.model.util.*;
import com.mygdx.game.model.entities.*;
import com.mygdx.game.model.entities.objetos.*;
import com.mygdx.game.model.entities.personagens.Arqueiro;
import com.mygdx.game.model.entities.personagens.Barbaro;
import com.mygdx.game.model.entities.personagens.Guerreiro;
import com.mygdx.game.model.entities.personagens.Mago;

public class PersonagemController {
	
	public static Personagem p;
	
	PersonagemController() {
		TabuleiroController.tabuleiro.getCasas()[p.getLinha()][p.getColuna()].setComponente(p);
	}
	
	public static void move(int novaLinha, int novaColuna) {
		if (!p.isDireita() && p.getLinha() == novaLinha && p.getColuna() == novaColuna - 1) {
			p.mudaDirecao();
			return;
		}
		if (p.isDireita() && p.getLinha() == novaLinha && p.getColuna() == novaColuna + 1) {
			p.mudaDirecao();
			return;
		}
		char caractere = TabuleiroController.tabuleiro.getBoard()[novaLinha][novaColuna].charAt(0);
		Componente c = TabuleiroController.tabuleiro.getCasas()[novaLinha][novaColuna].getComponente();
		if (caractere == 'p')
			return;
		if (caractere == 'D')
			return;
		if (caractere == 'C') {
			((Bau) c).abrir(p);
			return;
		}
		if (caractere == 'K') {
			p.addChave(((Chave) c).getID());
			MainController.setMensagem("Voce coletou a chave " + ((Chave) c).getID());
			ObjetoController.removeObject(novaLinha, novaColuna);
		}
		if (caractere == 'B') {
			if (p.getChaves()[((Porta) c).getID()] != null) {
				MainController.setMensagem("Voce abriu a porta " + ((Porta) c).getID());
				ObjetoController.removeObject(novaLinha, novaColuna);
			} else {
				return;
			}
		}
		ObjetoController.removeObject(p.getLinha(), p.getColuna());
		TabuleiroController.tabuleiro.getCasas()[p.getLinha()][p.getColuna()].setComponente(null);
		p.setLinha(novaLinha);
		p.setColuna(novaColuna);
		TabuleiroController.tabuleiro.getCasas()[p.getLinha()][p.getColuna()].setComponente(p);
	}
	
	public static ArrayList<Integer> area(Direcao direcao) {
		return p.area(direcao);
	}
	
	public static boolean lastPosition() {
		return p.getLinha() == 23 && p.getColuna() == 23;
	}
	
	public static void setP(int id, int linha, int coluna, int vida, int range, int dano) {
		if (id == 0)
			 p = new Mago(linha, coluna, vida, range, dano);
		else if (id == 1)
			p = new Guerreiro(linha, coluna, vida, range, dano);
		else if (id == 2)
			p = new Arqueiro(linha, coluna, vida, range, dano);
		else
			p = new Barbaro(linha, coluna, vida, range, dano);
		TabuleiroController.tabuleiro.getCasas()[1][1].setComponente(p);
	}
	
	public static Ataque atacar(Direcao direcao, int a, int b) {
		return p.atacar(direcao, a, b);
	}

	public static Texture imagemAtaque(Direcao direcao) {
		return p.getAtaque(direcao);
	}
	
	public static Texture getConfirmationScreen() {
		return p.getTela();
	}
	
	public static Texture getImg() {
		return p.getImg();
	}
	
	public static Texture getChaveImg(int i) {
		return p.getChaves()[i].getImg();
	}
	
	public static Chave getChave(int i) {
		return p.getChaves()[i];
	}
	
	public static int getLinha() { 
		return p.getLinha();
	}
	
	public static int getColuna() {
		return p.getColuna();
	}
	
	public static int getTipo() {
		return p.getTipo();
	}
	
	public static boolean isDead() {
		return p.getVida() <= 0;
	}
	
	public static int getVida() {
		return p.getVida();
	}
	
	public static int getDano() {
		return p.getDano();
	}
	
	public static int getRange() {
		return p.getRange();
	}
	
	public static int getScore() {
		return p.getScore();
	}
}
