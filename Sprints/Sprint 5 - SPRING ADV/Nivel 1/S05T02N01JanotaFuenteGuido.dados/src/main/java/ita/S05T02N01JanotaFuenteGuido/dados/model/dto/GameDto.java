package ita.S05T02N01JanotaFuenteGuido.dados.model.dto;


public class GameDto {
	

	private int id;
	private int diceA;
	private int diceB;
	private boolean win;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDiceA() {
		return diceA;
	}
	public void setDiceA(int diceA) {
		this.diceA = diceA;
	}
	public int getDiceB() {
		return diceB;
	}
	public void setDiceB(int diceB) {
		this.diceB = diceB;
	}
	public boolean isWin() {
		return win;
	}
	public void setWin(boolean win) {
		this.win = win;
	}

	
}
