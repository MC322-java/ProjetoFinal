package com.mygdx.game.model.entities.personagens;

import java.util.ArrayList;

import com.mygdx.game.model.entities.Componente;
import com.mygdx.game.model.entities.Dragao;
import com.mygdx.game.model.entities.Personagem;
import com.mygdx.game.model.entities.Tabuleiro;
import com.mygdx.game.model.util.*;

public class Guerreiro extends Personagem {

	@Override
	public void atacar(Tabuleiro tabuleiro) {
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
				for (Componente c : tabuleiro.getCasas()[i][j].getComponentes()) {
					if (Util.isInstance(c, (new Dragao()).getClass())) {
						if (dadoPlayer >= dadoDragoes) {
							dragoes.add((Dragao) c);
						} else {
							danoRecebido = Math.max(danoRecebido, ((Dragao) c).getDano());
						}
					}
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
