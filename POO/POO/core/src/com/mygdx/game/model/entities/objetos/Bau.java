package com.mygdx.game.model.entities.objetos;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.model.Texto;
import com.mygdx.game.model.entities.Objeto;
import com.mygdx.game.model.entities.Personagem;
import com.mygdx.game.model.entities.personagens.Arqueiro;
import com.mygdx.game.model.entities.personagens.Mago;
import com.mygdx.game.model.util.Util;

public class Bau extends Objeto {
	
	private boolean aberto;
	private Texture abertoImg, fechadoImg;
	
	public Bau() {
		setAberto(false);
		abertoImg = new Texture("bau-aberto.png");
		fechadoImg = new Texture("bau.png");
		this.setImg(fechadoImg);
	}

	public void abrir(Personagem p, Texto texto) {
		if (isAberto()) return;
		Random rand = new Random();
		int x = rand.nextInt(3);
		if (x == 0) {
			// dano
			int wtf = rand.nextInt(5) + 6;
			texto.setMensagem("Voce ganhou +" + wtf + " de dano");
			p.setDano(p.getDano() + wtf);
		} else if (x == 1) {
			// vida
			int wtf = rand.nextInt(10) + 11;
			texto.setMensagem("Voce ganhou +" + wtf + " de vida");
			p.setVida(p.getVida() + wtf);
		} else {
			// range
			if (Util.isInstance(p, (new Arqueiro()).getClass())) {
				int wtf = 2 * (rand.nextInt(3) + 1);
				texto.setMensagem("Voce ganhou +" + wtf + " de range");
				p.setRange(p.getRange() + wtf);
			} else {
				texto.setMensagem("Voce ganhou +1 de range");
				p.setRange(p.getRange() + 1);
			}
		}
		setAberto(true);
	}
	
	public boolean isAberto() {
		return aberto;
	}

	public void setAberto(boolean aberto) {
		if (aberto)
			this.setImg(abertoImg);
		this.aberto = aberto;
	}
}
