package com.mygdx.game.controller;

import com.badlogic.gdx.math.MathUtils;

public class MainController {
	
	public static boolean isInstance(Object object, Class<?> type) {
	    return type.isInstance(object);
	}
	
	public static int jogaDado() {
		return MathUtils.random.nextInt(20) + 1;
	}
}
