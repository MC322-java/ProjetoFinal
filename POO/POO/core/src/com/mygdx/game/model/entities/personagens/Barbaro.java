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
		this.setImgDireita(new Texture("Characters/barbaro-direita.png"));
		this.setImgEsquerda(new Texture("Characters/barbaro-esquerda.png"));
		this.setImg(this.getImgDireita());
	}
	
	public Barbaro(int linha, int coluna, int vida, int range, int dano) {
		setLinha(linha);
		setColuna(coluna);
		setVida(vida);
		setRange(range);
		setDano(dano);
		this.setImgDireita(new Texture("Characters/barbaro-direita.png"));
		this.setImgEsquerda(new Texture("Characters/barbaro-esquerda.png"));
		this.setImg(this.getImgDireita());
	}

	@Override
	public int atacar() {
		// fazer um ataque em numa area de acordo com a arma equipada (a arma altera o range e o dano)
		
		// ataque numa area range x range
		// com centro na posicao em que eu estou
		int dadoPlayer = Util.jogaDado();
		int dadoDragoes = Util.jogaDado();
		int danoRecebido = 0;
		ArrayList<Dragao> dragoes = new ArrayList<Dragao>();
		for (int i = this.linha - range / 2; i < this.linha + range / 2; i++) {
			for (int j = this.coluna - range / 2; j < this.coluna + range / 2; j++) {
				if (i != this.linha && j != this.coluna)
					continue;
				Componente c = TabuleiroController.tabuleiro.getCasas()[i][j].getComponente();
				if (Util.isInstance(c, (new Dragao()).getClass())) {
					if (dadoPlayer >= dadoDragoes)
						dragoes.add((Dragao) c);
					else
						danoRecebido = Math.max(danoRecebido, ((Dragao) c).getDano());
				}
			}
		}
		vida -= danoRecebido;
		for (Dragao d : dragoes) {
			d.setVida(d.getVida() - dano / dragoes.size());
			// OLHAR SE O DRAGAO MORREU
		}
		return 1;
	}	
}
