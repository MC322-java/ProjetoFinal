package com.mygdx.game.model.entities.objetos;

import com.badlogic.gdx.math.MathUtils;

public class Poder {
	
	enum Tipo {
		DANO,
		RANGE
	}
	
	private Tipo tipo;
	private int valor;
	
	Poder() {
		if (MathUtils.random.nextInt(1) == 0) {
			setTipo(Tipo.DANO);
		} else {
			setTipo(Tipo.RANGE);
		}
		setValor(MathUtils.random.nextInt(10) + 1);
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
}
