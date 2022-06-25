package com.mygdx.game.model.entities.objetos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.model.entities.Objeto;

public class Pocao extends Objeto {

	private int pontosDeVida;

	public Pocao() {
		this.setImg(new Texture("pocao.png"));
	}
	
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
