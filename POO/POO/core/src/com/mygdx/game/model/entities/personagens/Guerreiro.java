package com.mygdx.game.model.entities.personagens;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.controller.ObjetoController;
import com.mygdx.game.controller.PersonagemController;
import com.mygdx.game.controller.TabuleiroController;
import com.mygdx.game.model.entities.Componente;
import com.mygdx.game.model.entities.Dragao;
import com.mygdx.game.model.entities.Personagem;
import com.mygdx.game.model.entities.Tabuleiro;
import com.mygdx.game.model.util.*;

public class Guerreiro extends Personagem {
	
	public Guerreiro() {
		super();
		this.setImgDireita(new Texture("Characters/guerreiro-direita.png"));
		this.setImgEsquerda(new Texture("Characters/guerreiro-esquerda.png"));
		this.setImg(this.getImgDireita());
		this.nome = "Guerreiro";
		setTela();
	}
	
	public Guerreiro(int linha, int coluna, int vida, int range, int dano) {
		super();
		setLinha(linha);
		setColuna(coluna);
		setVida(vida);
		setRange(range);
		setDano(dano);
		this.setImgDireita(new Texture("Characters/guerreiro-direita.png"));
		this.setImgEsquerda(new Texture("Characters/guerreiro-esquerda.png"));
		this.setImg(this.getImgDireita());
		this.nome = "Guerreiro";
		setTela();
	}

	@Override
	public ArrayList<Integer> area() {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		return ret;
	}
	
	@Override
	public Ataque atacar(Direcao direcao) {
//		int dadoPlayer = Util.jogaDado();
//		int dadoDragoes = Util.jogaDado();
		int dadoPlayer = 1;
		int dadoDragoes = 0;
		Dragao dragao = null;
		int start = 0;
		int end = 0;
		if (direcao == Direcao.DIREITA) {
			for (int i = Math.min(coluna + 1, 24); i <= Math.min(coluna + range, 24); i++) {
				Componente c = TabuleiroController.tabuleiro.getCasas()[linha][i].getComponente();
				if (TabuleiroController.tabuleiro.getBoard()[linha][i] == " ") continue;
				if (c != null && Util.isInstance(c, (new Dragao()).getClass())) {
					dragao = (Dragao) TabuleiroController.tabuleiro.getCasas()[linha][i].getComponente();
					break;
				} else {
					return Ataque.VENTO;
				}
			}
		} else if (direcao == Direcao.ESQUERDA) {
			for (int i = Math.max(coluna - 1, 0); i >= Math.max(coluna - range, 0); i--) {
				Componente c = TabuleiroController.tabuleiro.getCasas()[linha][i].getComponente();
				if (TabuleiroController.tabuleiro.getBoard()[linha][i] == " ") continue;
				if (c != null && Util.isInstance(c, (new Dragao()).getClass())) {
					dragao = (Dragao) TabuleiroController.tabuleiro.getCasas()[linha][i].getComponente();
					break;
				} else {
					return Ataque.VENTO;
				}
			}
		} else if (direcao == Direcao.BAIXO) {
			for (int i = Math.min(linha + 1, 23); i <= Math.min(linha + range, 23); i++) {
				Componente c = TabuleiroController.tabuleiro.getCasas()[i][coluna].getComponente();
				if (TabuleiroController.tabuleiro.getBoard()[linha][i] == " ") continue;
				if (c != null && Util.isInstance(c, (new Dragao()).getClass())) {
					dragao = (Dragao) TabuleiroController.tabuleiro.getCasas()[i][coluna].getComponente();
					break;
				} else {
					return Ataque.VENTO;
				}
			}
		} else {
			for (int i = Math.max(linha - 1, 0); i >= Math.max(linha - range, 0); i--) {
				Componente c = TabuleiroController.tabuleiro.getCasas()[i][coluna].getComponente();
				if (TabuleiroController.tabuleiro.getBoard()[linha][i] == " ") continue;
				if (c != null && Util.isInstance(c, (new Dragao()).getClass())) {
					dragao = (Dragao) TabuleiroController.tabuleiro.getCasas()[i][coluna].getComponente();
					break;
				} else {
					return Ataque.VENTO;
				}
			}
		}
		if (dragao == null)
			return Ataque.VENTO;
		ObjetoController.removeObject(dragao.getLinha(), dragao.getColuna());
		if (dadoPlayer < dadoDragoes) {
			setVida(getVida() - dragao.getDano());
			return Ataque.FALHOU;
		}
		dragao.setVida(dragao.getVida() - dano);
		return Ataque.ACERTOU;
	}
}
