package com.mygdx.game.model.util;

import com.badlogic.gdx.math.MathUtils;

public abstract class Util {
	
	public static boolean isInstance(Object object, Class<?> type) {
	    return object.getClass() == type;
	}
	
	public static int jogaDado() {
		return MathUtils.random.nextInt(20);
	}

	public static boolean posicaoValida(int novaLinha, int novaColuna) {
		return 1 <= novaLinha && novaLinha <= 23 && 1 <= novaColuna && novaColuna <= 23;
	}
}
