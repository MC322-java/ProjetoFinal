package com.mygdx.game.model.entities;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.controller.PersonagemController;
import com.mygdx.game.model.entities.objetos.Bau;
import com.mygdx.game.model.entities.objetos.Chave;
import com.mygdx.game.model.entities.objetos.Porta;

public class Tabuleiro {
	private int tamanho;
	private Casa[][] casas;
	private String board[][] = {
		    {"p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p"},
		    {"p", " ", " ", " ", "K1", " ", " ", " ", "p", "p", "p", " ", " ", " ", " ", " ", " ", " ", " ", "D", " ", " ", " ", " ", "p"},
		    {"p", "p", "p", "p", "p", "p", "p", "B1", "p", "p", "p", " ", "p", "p", "p", "p", "p", "p", "p", "p", " ", " ", " ", " ", "p"},
		    {"p", " ", " ", " ", "p", "p", " ", " ", " ", " ", "p", " ", "p", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "p"},
		    {"p", " ", "p", " ", "p", "p", " ", " ", " ", " ", "p", " ", "p", " ", "p", "p", "p", "p", "p", " ", "p", "p", "p", "p", "p"},
		    {"p", " ", "p", " ", " ", " ", " ", " ", " ", " ", "p", " ", "p", " ", "p", "p", "p", "p", "p", " ", " ", " ", " ", " ", "p"},
		    {"p", " ", "p", "p", "p", " ", " ", " ", " ", " ", "p", " ", "p", " ", "p", "p", "p", "C", " ", "p", "p", "p", "p", "p", "p"},
		    {"p", " ", "p", "p", "p", " ", " ", "D", " ", " ", "p", " ", "p", " ", "p", "p", "p", " ", " ", " ", " ", " ", " ", " ", "p"},
		    {"p", "K2", "p", "p", "p", "p", "p", "B2", "p", "p", "p", " ", "p", " ", " ", " ", "p", "p", "p", " ", "p", "p", "p", "D", "p"},
		    {"p", " ", " ", " ", "p", " ", " ", " ", " ", " ", " ", " ", "p", " ", " ", " ", " ", "p", "p", " ", "p", " ", " ", " ", "p"},
		    {"p", "p", "p", "B3", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", " ", " ", "p", "p", " ", "p", "K3", " ", " ", "p"},
		    {"p", " ", " ", "D", " ", " ", " ", " ", " ", "D", " ", "C", "p", "p", "p", " ", " ", " ", " ", " ", "p", "p", "p", "C", "p"},
		    {"p", " ", "p", " ", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p"},
		    {"p", " ", " ", " ", "p", "p", "p", "K6", " ", " ", " ", " ", "p", "p", "p", "p", " ", " ", " ", " ", " ", " ", " ", " ", "p"},
		    {"p", "p", "p", " ", "p", "p", "p", " ", " ", " ", " ", " ", "p", "p", "p", "p", " ", " ", " ", " ", "p", "p", "p", "B6", "p"},
		    {"p", " ", " ", " ", " ", "p", "p", " ", " ", " ", " ", " ", "D", " ", " ", " ", " ", " ", " ", " ", "p", " ", " ", " ", "p"},
		    {"p", " ", " ", " ", " ", "p", "p", "p", "p", "p", "p", "p", "p", " ", "p", "p", "p", "p", "p", "p", "p", " ", "p", " ", "p"},
		    {"p", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "p", "p", " ", " ", "p", " ", " ", " ", " ", " ", "p"},
		    {"p", " ", " ", " ", " ", "p", "p", "p", "p", " ", " ", " ", " ", " ", "p", "p", " ", " ", "p", "K4", " ", "p", "p", "p", "p"},
		    {"p", " ", " ", " ", " ", " ", "p", "K5", "p", " ", " ", " ", " ", " ", "p", "p", " ", " ", "p", "p", "p", "p", "C", "C", "p"},
		    {"p", "p", "p", "B4", "p", "p", "p", " ", "p", " ", " ", " ", " ", " ", "p", "p", " ", " ", "p", "p", "p", "p", " ", " ", "p"},
		    {"p", " ", " ", " ", " ", " ", "p", " ", "p", " ", " ", " ", " ", " ", " ", " ", "D", "D", " ", " ", " ", " ", " ", " ", "p"},
		    {"p", " ", " ", " ", " ", " ", "p", " ", "p", "B5", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p"},
		    {"p", " ", " ", " ", " ", " ", "D", " ", "p", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "D", " ", "p"},
		    {"p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p"}
	};
	
	public Tabuleiro() {
		setCasas(new Casa[25][25]);
		for (int i = 0; i < 25; i++) {
			for (int j = 0; j < 25; j++) {
				getCasas()[i][j] = new Casa(this, null);
				if (board[i][j] == "D")
					getCasas()[i][j].setComponente(new Dragao(i, j, 1, 1));
				else if (board[i][j].charAt(0) == 'B')
					getCasas()[i][j].setComponente(new Porta(Integer.parseInt(board[i][j].substring(1, 2))));
				else if (board[i][j] == "C")
					getCasas()[i][j].setComponente(new Bau());
				else if (board[i][j].charAt(0) == 'K')
					getCasas()[i][j].setComponente(new Chave(Integer.parseInt(board[i][j].substring(1, 2))));
//				if (i == 1 && j == 1)
//					getCasas()[i][j].setComponente(PersonagemController.p);
			}
		}
	}
	
	public int getTamanho() {
		return tamanho;
	}
	
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	
	public Casa[][] getCasas() {
		return casas;
	}
	
	public void setCasas(Casa[][] casas) {
		this.casas = casas;
	}
	
	public String[][] getBoard() {
		return board;
	}
	
	public void setBoard(String[][] board) {
		this.board = board;
	}
}
