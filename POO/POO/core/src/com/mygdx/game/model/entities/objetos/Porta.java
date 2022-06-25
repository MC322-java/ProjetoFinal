package com.mygdx.game.model.entities.objetos;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.model.entities.Objeto;

public class Porta extends Objeto{
	
	private int ID;
	
	public Porta() {
		this.setImg(new Texture("porta.png"));
	}
	
	public Porta(int id) {
		setID(id);
		this.setImg(new Texture("Portas/"+ id + ".png"));
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
}
