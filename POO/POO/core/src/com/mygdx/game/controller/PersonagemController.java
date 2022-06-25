package com.mygdx.game.controller;

import com.mygdx.game.model.entities.Componente;
import com.mygdx.game.model.entities.Personagem;
import com.mygdx.game.model.entities.objetos.Chave;
import com.mygdx.game.model.entities.objetos.Porta;
import com.mygdx.game.model.entities.personagens.Guerreiro;
import com.mygdx.game.model.entities.personagens.Mago;
import com.mygdx.game.model.util.Util;
import com.mygdx.game.view.MapScreen;

public class PersonagemController {
	
	public static Personagem p = new Guerreiro(1, 1, 100, 10, 10);
	
	PersonagemController() {
		TabuleiroController.tabuleiro.getCasas()[p.getLinha()][p.getColuna()].setComponente(p);
	}
	
	public static void move(int novaLinha, int novaColuna) {
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
	
	public static void atacar() {
		p.atacar(TabuleiroController.tabuleiro);
	}
}
