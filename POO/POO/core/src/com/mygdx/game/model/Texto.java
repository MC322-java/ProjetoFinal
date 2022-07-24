package com.mygdx.game.model;

public class Texto {
	
	private static String mensagem = "";
	
	public Texto() {}

	public static String getMensagem() {
		return mensagem;
	}

	public static void setMensagem(String msg) {
		mensagem = msg;
	}
}
