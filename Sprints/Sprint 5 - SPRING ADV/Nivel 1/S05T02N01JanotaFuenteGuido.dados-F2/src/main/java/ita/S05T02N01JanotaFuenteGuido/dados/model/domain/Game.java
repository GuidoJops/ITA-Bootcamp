package ita.S05T02N01JanotaFuenteGuido.dados.model.domain;

public class Game {
	
	private int diceA;
	
	private int diceB;
	
	private boolean win;

	
	
	public Game() {

		diceA = (int)(Math.random()*6)+1;
		diceB = (int)(Math.random()*6)+1;
		win = winLose();
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

	@Override
	public String toString() {
		return "Game [ diceA=" + diceA + ", diceB=" + diceB + ", win=" + win + "]";
	}
	public boolean winLose() {
		return diceA + diceB == 7;
	}
	
	
	

}
