package com.mygdx.game.model.util;

import com.badlogic.gdx.math.MathUtils;

public abstract class Util {
	
	public static boolean isInstance(Object object, Class<?> type) {
	    return type.isInstance(object);
	}
	
	public static int jogaDado() {
		return MathUtils.random.nextInt(20) + 1;
	}
}
