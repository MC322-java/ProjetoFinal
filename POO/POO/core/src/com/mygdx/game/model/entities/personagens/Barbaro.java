package com.mygdx.game.model.entities.personagens;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.controller.TabuleiroController;
import com.mygdx.game.model.entities.Componente;
import com.mygdx.game.model.entities.Dragao;
import com.mygdx.game.model.entities.Personagem;
import com.mygdx.game.model.entities.Tabuleiro;
import com.mygdx.game.model.util.*;

public class Barbaro extends Personagem {
	
	public Barbaro() {
		super();
		this.setImgDireita(new Texture("Characters/barbaro-direita.png"));
		this.setImgEsquerda(new Texture("Characters/barbaro-esquerda.png"));
		this.setImg(this.getImgDireita());
		this.nome = "Barbaro";
		setTela();
	}
	
	public Barbaro(int linha, int coluna, int vida, int range, int dano) {
		super();
		setLinha(linha);
		setColuna(coluna);
		setVida(vida);
		setRange(range);
		setDano(dano);
		this.setImgDireita(new Texture("Characters/barbaro-direita.png"));
		this.setImgEsquerda(new Texture("Characters/barbaro-esquerda.png"));
		this.setImg(this.getImgDireita());
		this.nome = "Barbaro";
		setTela();
	}
	
	@Override
	public ArrayList<Integer> area() {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		return ret;
	}

	@Override
	public Ataque atacar(Direcao direcao) {
		// fazer um ataque em numa area de acordo com a arma equipada (a arma altera o range e o dano)
		
		// ataque numa area range x range
		// com centro na posicao em que eu estou
		Dragao drag = new Dragao();
//		int dadoPlayer = Util.jogaDado();
//		int dadoDragoes = Util.jogaDado();
		int dadoPlayer = 1;
		int dadoDragoes = 0;
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
//			d.setVida(d.getVida() - dano / dragoes.size());
			d.setVida(0);
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
}
