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
	
	public static Personagem p;
	
	PersonagemController() {
		TabuleiroController.tabuleiro.getCasas()[p.getLinha()][p.getColuna()].setComponente(p);
	}
	
	public static void move(int novaLinha, int novaColuna) {
		if (!p.isDireita() && p.getLinha() == novaLinha && p.getColuna() == novaColuna - 1)
			p.mudaDirecao();
		if (p.isDireita() && p.getLinha() == novaLinha && p.getColuna() == novaColuna + 1)
			p.mudaDirecao();
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
	
	public static void setP(Personagem p) {
		PersonagemController.p = p;
	}
	
	public static int atacar() {
		return p.atacar();
	}
}
