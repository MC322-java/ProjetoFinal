package com.mygdx.game.model.entities.personagens;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.DungeonsAndDragons;
import com.mygdx.game.controller.TabuleiroController;
import com.mygdx.game.model.Texto;
import com.mygdx.game.model.entities.Componente;
import com.mygdx.game.model.entities.Dragao;
import com.mygdx.game.model.entities.Personagem;
import com.mygdx.game.model.entities.Tabuleiro;
import com.mygdx.game.model.util.*;

public class Barbaro extends Personagem {
	
	private Texture ataque;
	
	public Barbaro() {
		super();
		this.setImgDireita(new Texture("Characters/barbaro-direita.png"));
		this.setImgEsquerda(new Texture("Characters/barbaro-esquerda.png"));
		this.setImg(this.getImgDireita());
		this.setTipo(0);
		this.nome = "Barbaro";
		this.ataque = new Texture("ataque-barbaro.png");
		this.Score = 0;
		setTela();
	}
	
	public Barbaro(int linha, int coluna, int vida, int range, int dano) {
		super();
		setLinha(linha);
		setColuna(coluna);
		setVida(vida);
		this.setRange(range);
		setDano(dano);
		this.setImgDireita(new Texture("Characters/barbaro-direita.png"));
		this.setImgEsquerda(new Texture("Characters/barbaro-esquerda.png"));
		this.setImg(this.getImgDireita());
		this.setTipo(0);
		this.nome = "Barbaro";
		this.ataque = new Texture("ataque-barbaro.png");
		this.Score = 0;
		setTela();
	}
	
	@Override
	public ArrayList<Integer> area(Direcao direcao) {
		ArrayList<Integer> vi = new ArrayList<Integer>();
		ArrayList<Integer> vj = new ArrayList<Integer>();
		int dx[] = {1, 1, -1, -1};
		int dy[] = {1, -1, -1, 1};
		for (int i = 1; i <= range; i++) {
			int a = linha - i;
			int b = coluna;
			for (int k = 0; k < 4; k++) {
				for (int j = 0; j < i; j++) {
					a += dx[k]; b += dy[k];
					if (!Util.posicaoValida(a, b))
						continue;
					if (TabuleiroController.tabuleiro.getBoard()[a][b].equals("p") 
						|| TabuleiroController.tabuleiro.getBoard()[a][b].equals("C")
						|| TabuleiroController.tabuleiro.getBoard()[a][b].charAt(0) == 'B'
						|| (i == this.linha && j == this.coluna))
						continue;
					vi.add(a);
					vj.add(b);
				}
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
	public Ataque atacar(Direcao direcao, int dadoPlayer, int dadoDragoes, Texto texto) {
		Dragao drag = new Dragao();
		int danoRecebido = 0;
		ArrayList<Dragao> dragoes = new ArrayList<Dragao>();
		for (int i = 1; i <= range; i++) {
			int a = linha - i;
			int b = coluna;
			for (int j = 0; j < i; j++) {
				a++; b++;
				if (!Util.posicaoValida(a, b)) continue;
				Componente c = TabuleiroController.tabuleiro.getCasas()[a][b].getComponente();
				if (c != null && Util.isInstance(c, drag.getClass())) {
					if (dadoPlayer >= dadoDragoes)
						dragoes.add((Dragao) c);
					else
						danoRecebido = Math.max(danoRecebido, ((Dragao) c).getDano());
				}
			}
			for (int j = 0; j < i; j++) {
				a++; b--;
				if (!Util.posicaoValida(a, b)) continue;
				Componente c = TabuleiroController.tabuleiro.getCasas()[a][b].getComponente();
				if (c != null && Util.isInstance(c, drag.getClass())) {
					if (dadoPlayer >= dadoDragoes)
						dragoes.add((Dragao) c);
					else
						danoRecebido = Math.max(danoRecebido, ((Dragao) c).getDano());
				}
			}
			for (int j = 0; j < i; j++) {
				a--; b--;
				if (!Util.posicaoValida(a, b)) continue;
				Componente c = TabuleiroController.tabuleiro.getCasas()[a][b].getComponente();
				if (c != null && Util.isInstance(c, drag.getClass())) {
					if (dadoPlayer >= dadoDragoes)
						dragoes.add((Dragao) c);
					else
						danoRecebido = Math.max(danoRecebido, ((Dragao) c).getDano());
				}
			}
			for (int j = 0; j < i; j++) {
				a--; b++;
				if (!Util.posicaoValida(a, b)) continue;
				Componente c = TabuleiroController.tabuleiro.getCasas()[a][b].getComponente();
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
				setScore( getScore() + 100);
				cntMortos++;
			}
		}
		if (danoRecebido > 0) {
			texto.setMensagem("Voce recebeu " + danoRecebido + " de dano");
			return Ataque.FALHOU;
		}
		texto.setMensagem("Voce causou" + dano + " de dano");
		return Ataque.ACERTOU;
	}

	@Override
	public Texture getAtaque(Direcao direcao) {
		return this.ataque;
	}
	
	@Override
	public void setRange(int range) {
		this.range = Math.min(range, 3);
	}
}
