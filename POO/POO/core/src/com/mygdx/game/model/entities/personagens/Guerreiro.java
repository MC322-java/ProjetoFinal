package com.mygdx.game.model.entities.personagens;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.DungeonsAndDragons;
import com.mygdx.game.controller.ObjetoController;
import com.mygdx.game.controller.PersonagemController;
import com.mygdx.game.controller.TabuleiroController;
import com.mygdx.game.model.entities.Componente;
import com.mygdx.game.model.entities.Dragao;
import com.mygdx.game.model.entities.Personagem;
import com.mygdx.game.model.entities.Tabuleiro;
import com.mygdx.game.model.util.*;

public class Guerreiro extends Personagem {
	
	private Texture cima, baixo, esquerda, direita;
	
	public Guerreiro() {
		super();
		this.setImgDireita(new Texture("Characters/guerreiro-direita.png"));
		this.setImgEsquerda(new Texture("Characters/guerreiro-esquerda.png"));
		this.setImg(this.getImgDireita());
		this.setTipo(1);
		this.cima = new Texture("ataque-guerreiro-cima.png");
		this.baixo = new Texture("ataque-guerreiro-baixo.png");
		this.esquerda = new Texture("ataque-guerreiro-esquerda.png");
		this.direita = new Texture("ataque-guerreiro-direita.png");
		this.nome = "Guerreiro";
		setTela();
	}
	
	public Guerreiro(int linha, int coluna, int vida, int range, int dano) {
		super();
		setLinha(linha);
		setColuna(coluna);
		setVida(vida);
		this.setRange(range);
		setDano(dano);
		this.setImgDireita(new Texture("Characters/guerreiro-direita.png"));
		this.setImgEsquerda(new Texture("Characters/guerreiro-esquerda.png"));
		this.setImg(this.getImgDireita());
		this.setTipo(1);
		this.cima = new Texture("ataque-guerreiro-cima.png");
		this.baixo = new Texture("ataque-guerreiro-baixo.png");
		this.esquerda = new Texture("ataque-guerreiro-esquerda.png");
		this.direita = new Texture("ataque-guerreiro-direita.png");
		this.nome = "Guerreiro";
		setTela();
	}

	@Override
	public ArrayList<Integer> area(Direcao direcao) {
		ArrayList<Integer> vi = new ArrayList<Integer>();
		ArrayList<Integer> vj = new ArrayList<Integer>();
		if (direcao == Direcao.DIREITA) {
			for (int i = Math.min(coluna + 1, 24); i <= Math.min(coluna + range, 24); i++) {
				if (TabuleiroController.tabuleiro.getBoard()[linha][i] == "p"
					|| TabuleiroController.tabuleiro.getBoard()[linha][i] == "C"
					|| TabuleiroController.tabuleiro.getBoard()[linha][i].charAt(0) == 'B')
					break;
				vi.add(linha);
				vj.add(i);
				if (TabuleiroController.tabuleiro.getBoard()[linha][i] == "D")
					break;
			}
		} else if (direcao == Direcao.ESQUERDA) {
			for (int i = Math.max(coluna - 1, 0); i >= Math.max(coluna - range, 0); i--) {
				if (TabuleiroController.tabuleiro.getBoard()[linha][i] == "p"
						|| TabuleiroController.tabuleiro.getBoard()[linha][i] == "C"
						|| TabuleiroController.tabuleiro.getBoard()[linha][i].charAt(0) == 'B')
						break;
					vi.add(linha);
					vj.add(i);
					if (TabuleiroController.tabuleiro.getBoard()[linha][i] == "D")
						break;
			}
		} else if (direcao == Direcao.BAIXO) {
			for (int i = Math.min(linha + 1, 24); i <= Math.min(linha + range, 24); i++) {
				if (TabuleiroController.tabuleiro.getBoard()[i][coluna] == "p"
						|| TabuleiroController.tabuleiro.getBoard()[i][coluna] == "C"
						|| TabuleiroController.tabuleiro.getBoard()[i][coluna].charAt(0) == 'B')
						break;
					vi.add(i);
					vj.add(coluna);
					if (TabuleiroController.tabuleiro.getBoard()[i][coluna] == "D")
						break;
			}
		} else {
			for (int i = Math.max(linha - 1, 0); i >= Math.max(linha - range, 0); i--) {
				if (TabuleiroController.tabuleiro.getBoard()[i][coluna] == "p"
						|| TabuleiroController.tabuleiro.getBoard()[i][coluna] == "C"
						|| TabuleiroController.tabuleiro.getBoard()[i][coluna].charAt(0) == 'B')
						break;
					vi.add(i);
					vj.add(coluna);
					if (TabuleiroController.tabuleiro.getBoard()[i][coluna] == "D")
						break;
			}
		}
		ArrayList<Integer> ret = new ArrayList<Integer>();
		ret.add(vi.size());
		for (int x : vj)
			ret.add(x);
		for (int x : vi)
			ret.add(x);
		return ret;
	}
	
	@Override
	public Ataque atacar(Direcao direcao, int dadoPlayer, int dadoDragoes) {
		Dragao dragao = null;
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
			for (int i = Math.min(linha + 1, 24); i <= Math.min(linha + range, 24); i++) {
				Componente c = TabuleiroController.tabuleiro.getCasas()[i][coluna].getComponente();
				if (TabuleiroController.tabuleiro.getBoard()[i][coluna] == " ") continue;
				System.out.println("CASA DO CARA = " + TabuleiroController.tabuleiro.getBoard()[i][coluna]);
				if (c != null && Util.isInstance(c, (new Dragao()).getClass())) {
					System.out.println(i + ", " + coluna);
					dragao = (Dragao) TabuleiroController.tabuleiro.getCasas()[i][coluna].getComponente();
					break;
				} else {
					return Ataque.VENTO;
				}
			}
		} else {
			for (int i = Math.max(linha - 1, 0); i >= Math.max(linha - range, 0); i--) {
				Componente c = TabuleiroController.tabuleiro.getCasas()[i][coluna].getComponente();
				if (TabuleiroController.tabuleiro.getBoard()[i][coluna] == " ") continue;
				if (c != null && Util.isInstance(c, (new Dragao()).getClass())) {
					dragao = (Dragao) TabuleiroController.tabuleiro.getCasas()[i][coluna].getComponente();
					break;
				} else {
					return Ataque.VENTO;
				}
			}
		}
		if (dragao == null) {
			return Ataque.VENTO;
		}
		if (dadoPlayer < dadoDragoes) {
			setVida(getVida() - dragao.getDano());
			return Ataque.FALHOU;
		}
		dragao.setVida(dragao.getVida() - dano);
		if (dragao.getVida() == 0)
			ObjetoController.removeObject(dragao.getLinha(), dragao.getColuna());
		return Ataque.ACERTOU;
	}

	@Override
	public Texture getAtaque(Direcao direcao) {
		Texture xd = null;
		switch (direcao) {
			case CIMA:
				xd = cima;
				break;
			case BAIXO:
				xd = baixo;
				break;
			case DIREITA:
				xd = direita;
				break;
			case ESQUERDA:
				xd = esquerda;
				break;
			default:
				break;
		}
		return xd;
	}

	@Override
	public void setRange(int range) {
		this.range = Math.min(range, 6);
	}
}
