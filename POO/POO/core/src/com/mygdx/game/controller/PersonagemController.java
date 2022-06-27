package com.mygdx.game.controller;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.DungeonsAndDragons;
import com.mygdx.game.model.entities.Componente;
import com.mygdx.game.model.entities.Personagem;
import com.mygdx.game.model.entities.objetos.Chave;
import com.mygdx.game.model.entities.objetos.Porta;
import com.mygdx.game.model.entities.personagens.Arqueiro;
import com.mygdx.game.model.entities.personagens.Guerreiro;
import com.mygdx.game.model.entities.personagens.Mago;
import com.mygdx.game.model.util.Ataque;
import com.mygdx.game.model.util.Direcao;
import com.mygdx.game.model.util.Util;
import com.mygdx.game.view.MapScreen;

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
		if (caractere == 'K') {
			p.addChave(((Chave) c).getID());
			ObjetoController.removeObject(novaLinha, novaColuna);
		}
		if (caractere == 'B') {
			if (p.getChaves()[((Porta) c).getID()] != null) {
				System.out.println(((Porta) c).getID());
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
//		ArrayList<Integer> ret = p.area(direcao);
//		ArrayList<Integer> aux = new ArrayList<Integer>();
//		ArrayList<Integer> aux2 = new ArrayList<Integer>();
//		aux.add(ret.get(0));
//		for (int i = 1; i <= ret.get(0); i++) {
//			if (TabuleiroController.tabuleiro.getBoard()[ret.get(i) - 1][ret.get(i + ret.get(0)) - 1].equals("p"))
//				continue;
//			aux.add(ret.get(i));
//			aux2.add(ret.get(i + ret.get(0)));
//		}
//		for (int x : aux2)
//			aux.add(x);
//		aux.set(0, (aux.size() - 1) / 2);
//		return aux;
		return p.area(direcao);
	}
	
	public static boolean lastPosition() {
		return p.getLinha() == 23 && p.getColuna() == 23;
	}
	
	public static void setP(Personagem p) {
		PersonagemController.p = p;
		TabuleiroController.tabuleiro.getCasas()[1][1].setComponente(p);
	}
	
	public static Ataque atacar(Direcao direcao) {
		return p.atacar(direcao);
	}

	public static Texture imagemAtaque(Direcao direcao) {
//		if (Util.isInstance(p, (new Guerreiro()).getClass()) || Util.isInstance(p, (new Arqueiro()).getClass()))
		return p.getAtaque(direcao);
	}
}
