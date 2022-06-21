package com.mygdx.game.model;

import java.util.ArrayList;

import com.mygdx.game.controller.MainController;

public class Mago extends Personagem {

	@Override
	public void atacar(Tabuleiro tabuleiro) {
		// fazer um ataque em numa area de acordo com a arma equipada (a arma altera o range e o dano)
		
		// ataque numa area range x range
		// com centro na posicao em que eu estou
		int dadoPlayer = MainController.jogaDado();
		int dadoDragoes = MainController.jogaDado();
		int danoRecebido = 0;
		ArrayList<Dragao> dragoes = new ArrayList<Dragao>();
		for (int i = linha - range / 2; i < linha + range / 2; i++) {
			for (int j = coluna - range / 2; j < coluna + range / 2; j++) {
				for (Componente c : tabuleiro.getCasas()[i][j].getComponentes()) {
					if (MainController.isInstance(c, (new Dragao()).getClass())) {
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
