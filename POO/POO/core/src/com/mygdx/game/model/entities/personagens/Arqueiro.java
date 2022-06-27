package com.mygdx.game.model.entities.personagens;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.DungeonsAndDragons;
import com.mygdx.game.controller.ObjetoController;
import com.mygdx.game.controller.TabuleiroController;
import com.mygdx.game.model.entities.Componente;
import com.mygdx.game.model.entities.Dragao;
import com.mygdx.game.model.entities.Personagem;
import com.mygdx.game.model.entities.Tabuleiro;
import com.mygdx.game.model.util.*;

public class Arqueiro extends Personagem {
	
	public Arqueiro() {
		super();
		this.setImgDireita(new Texture("Characters/arqueiro-direita.png"));
		this.setImgEsquerda(new Texture("Characters/arqueiro-esquerda.png"));
		this.setImg(this.getImgDireita());
		this.nome = "Arqueiro";
		setTela();
	}
	
	public Arqueiro(int linha, int coluna, int vida, int range, int dano) {
		super();
		setLinha(linha);
		setColuna(coluna);
		setVida(vida);
		setRange(range);
		setDano(dano);
		this.setImgDireita(new Texture("Characters/arqueiro-direita.png"));
		this.setImgEsquerda(new Texture("Characters/arqueiro-esquerda.png"));
		this.setImg(this.getImgDireita());
		this.nome = "Arqueiro";
		setTela();
	}
	
	@Override
	public ArrayList<Integer> area(Direcao direcao) {
		ArrayList<Integer> vi = new ArrayList<Integer>();
		ArrayList<Integer> vj = new ArrayList<Integer>();
		if (direcao == Direcao.DIREITA) {
			for (int i = Math.min(coluna + 1, 24); i <= Math.min(coluna + range, 24); i++) {
				Componente c = TabuleiroController.tabuleiro.getCasas()[linha][i].getComponente();
				vi.add(linha);
				vj.add(i);
				if (TabuleiroController.tabuleiro.getBoard()[linha][i] == " ") continue;
				if (c != null && Util.isInstance(c, (new Dragao()).getClass())) {
					break;
				}
			}
		} else if (direcao == Direcao.ESQUERDA) {
			for (int i = Math.max(coluna - 1, 0); i >= Math.max(coluna - range, 0); i--) {
				Componente c = TabuleiroController.tabuleiro.getCasas()[linha][i].getComponente();
				vi.add(linha);
				vj.add(i);
				if (TabuleiroController.tabuleiro.getBoard()[linha][i] == " ") continue;
				if (c != null && Util.isInstance(c, (new Dragao()).getClass())) {
					break;
				}
			}
		} else if (direcao == Direcao.BAIXO) {
			for (int i = Math.min(linha + 1, 23); i <= Math.min(linha + range, 23); i++) {
				Componente c = TabuleiroController.tabuleiro.getCasas()[i][coluna].getComponente();
				vi.add(i);
				vj.add(coluna);
				if (TabuleiroController.tabuleiro.getBoard()[linha][i] == " ") continue;
				if (c != null && Util.isInstance(c, (new Dragao()).getClass())) {
					break;
				}
			}
		} else {
			for (int i = Math.max(linha - 1, 0); i >= Math.max(linha - range, 0); i--) {
				Componente c = TabuleiroController.tabuleiro.getCasas()[i][coluna].getComponente();
				vi.add(i);
				vj.add(coluna);
				if (TabuleiroController.tabuleiro.getBoard()[linha][i] == " ") continue;
				if (c != null && Util.isInstance(c, (new Dragao()).getClass())) {
					break;
				}
			}
		}
		ArrayList<Integer> ret = new ArrayList<Integer>();
		ret.add(vi.size());
		for (int x : vi)
			ret.add(x);
		for (int x : vj)
			ret.add(x);
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
