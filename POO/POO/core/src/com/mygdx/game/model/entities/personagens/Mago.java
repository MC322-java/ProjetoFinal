package com.mygdx.game.model.entities.personagens;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.DungeonsAndDragons;
import com.mygdx.game.controller.TabuleiroController;
import com.mygdx.game.model.entities.Componente;
import com.mygdx.game.model.entities.Dragao;
import com.mygdx.game.model.entities.Personagem;
import com.mygdx.game.model.entities.Tabuleiro;
import com.mygdx.game.model.util.*;

public class Mago extends Personagem {
	
	private Texture ataque;
	
	public Mago() {
		super();
		this.setImgDireita(new Texture("Characters/guerreiro-direita.png"));
		this.setImgEsquerda(new Texture("Characters/guerreiro-esquerda.png"));
		this.setImg(this.getImgDireita());
		this.setTipo(0);
		this.nome = "Mago";
		this.ataque = new Texture("ataque-mago.png");
		setTela();
	}
	
	public Mago(int linha, int coluna, int vida, int range, int dano) {
		super();
		setLinha(linha);
		setColuna(coluna);
		setVida(vida);
		this.setRange(range);
		setDano(dano);
		this.setImgDireita(new Texture("Characters/mago-direita.png"));
		this.setImgEsquerda(new Texture("Characters/mago-esquerda.png"));
		this.setImg(this.getImgDireita());
		this.setTipo(0);
		this.nome = "Mago";
		this.ataque = new Texture("ataque-mago.png");
		setTela();
	}

	@Override
	public ArrayList<Integer> area(Direcao direcao) {
		ArrayList<Integer> vi = new ArrayList<Integer>();
		ArrayList<Integer> vj = new ArrayList<Integer>();
		for (int i = Math.max(1, linha - range); i <= Math.min(linha + range, 24); i++) {
			for (int j = Math.max(1, coluna - range); j <= Math.min(coluna + range, 24); j++) {
				if (TabuleiroController.tabuleiro.getBoard()[i][j].equals("p") 
					|| TabuleiroController.tabuleiro.getBoard()[i][j].equals("C")
					|| TabuleiroController.tabuleiro.getBoard()[i][j].charAt(0) == 'B'
					|| (i == this.linha && j == this.coluna))
					continue;
				vi.add(i);
				vj.add(j);
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
		Dragao drag = new Dragao();
		int danoRecebido = 0;
		ArrayList<Dragao> dragoes = new ArrayList<Dragao>();
		for (int i = Math.max(1, linha - range); i <= Math.min(linha + range, 23); i++) {
			for (int j = Math.max(1, coluna - range); j <= Math.min(coluna + range, 23); j++) {
				if (i == this.linha && j == this.coluna)
					continue;
				Componente c = TabuleiroController.tabuleiro.getCasas()[i][j].getComponente();
				if (c != null && Util.isInstance(c, drag.getClass())) {
					if (dadoPlayer >= dadoDragoes)
						dragoes.add((Dragao) c);
					else
						danoRecebido = Math.max(danoRecebido, ((Dragao) c).getDano());
				}
			}
		}
		if (danoRecebido == 0 && dragoes.isEmpty())
			return Ataque.VENTO;
		vida -= danoRecebido;
		for (Dragao d : dragoes) {
			d.setVida(d.getVida() - dano);
		}
		int cntMortos = 0;
		for (Dragao d : dragoes) {
			System.out.println("O dragao em (" + d.getLinha() + ", " + d.getColuna() + ") morreu!");
			if (d.getVida() <= 0) {
				TabuleiroController.remove(d);
				cntMortos++;
			}
		}
		if (cntMortos == 0)
			return Ataque.FALHOU;
		return Ataque.ACERTOU;
	}

	@Override
	public Texture getAtaque(Direcao direcao) {
		return ataque;
	}

	@Override
	public void setRange(int range) {
		this.range = Math.min(range, 3);
	}
}
