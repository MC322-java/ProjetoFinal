package com.mygdx.game.model.entities.objetos;

import com.badlogic.gdx.math.MathUtils;

public class Pocao {

	private int pontosDeVida;

	Pocao() {}
	
	Pocao(int maximo) {
		setPontosDeVida(MathUtils.random.nextInt(maximo) + 1);
	}
	
	public int getPontosDeVida() {
		return pontosDeVida;
	}

	public void setPontosDeVida(int pontosDeVida) {
		this.pontosDeVida = pontosDeVida;
	}
}
