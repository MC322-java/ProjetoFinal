package com.mygdx.game.model.entities.objetos;

import com.badlogic.gdx.graphics.Texture;

import com.mygdx.game.model.entities.Objeto;

public class Chave extends Objeto{
	
	private int ID;
	
	public Chave() {
		this.setImg(new Texture("chave.png"));
	}
	
	public Chave(int id) {
		setID(id);
		this.setImg(new Texture("Keys/"+ id + ".png"));
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
}
