package com.mygdx.game.model.entities.personagens;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.controller.TabuleiroController;
import com.mygdx.game.model.entities.Componente;
import com.mygdx.game.model.entities.Dragao;
import com.mygdx.game.model.entities.Personagem;
import com.mygdx.game.model.entities.Tabuleiro;
import com.mygdx.game.model.util.*;

public class Mago extends Personagem {
	
	public Mago() {
		super();
		this.setImg(new Texture("mago.png"));
	}
	
	public Mago(int linha, int coluna, int vida, int range, int dano) {
		setLinha(linha);
		setColuna(coluna);
		setVida(vida);
		setRange(range);
		setDano(dano);
		this.setImg(new Texture("mago.png"));
	}

	@Override
	public void atacar(Tabuleiro tabuleiro) {
		// fazer um ataque em numa area de acordo com a arma equipada (a arma altera o range e o dano)
		
		// ataque numa area range x range
		// com centro na posicao em que eu estou
		int dadoPlayer = Util.jogaDado();
		int dadoDragoes = Util.jogaDado();
		int danoRecebido = 0;
		ArrayList<Dragao> dragoes = new ArrayList<Dragao>();
		for (int i = linha - range / 2; i < linha + range / 2; i++) {
			for (int j = coluna - range / 2; j < coluna + range / 2; j++) {
				if (i != this.linha && j != this.coluna)
					continue;
				Componente c = tabuleiro.getCasas()[i][j].getComponente();
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
	}
}
