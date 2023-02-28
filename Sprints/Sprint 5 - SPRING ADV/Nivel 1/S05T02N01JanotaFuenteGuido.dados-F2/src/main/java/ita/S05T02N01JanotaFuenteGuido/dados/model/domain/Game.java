package ita.S05T02N01JanotaFuenteGuido.dados.model.domain;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


//@Document(collection = "games")
public class Game {
	
	//private String id;
	
	private int diceA;
	
	private int diceB;
	
	private boolean win;
	
//	private Player player;

	
	public Game() {

		diceA = (int)(Math.random()*6)+1;
		diceB = (int)(Math.random()*6)+1;
		win = winLose();
	}
	
//	public Game() {
//
//	}
//	public Game(Player player) {
//		this.player = player;
//		diceA = (int)(Math.random()*6)+1;
//		diceB = (int)(Math.random()*6)+1;
//		win = winLose();
//	}
	

//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}

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

//	public Player getPlayer() {
//		return player;
//	}
//
//	public void setPlayer(Player player) {
//		this.player = player;
//	}
//	
	
	@Override
	public String toString() {
		return "Game [diceA=" + diceA + ", diceB=" + diceB + ", win=" + win;
		//+ ", player=" + player + "]";
	}
	
	public boolean winLose() {
		return diceA + diceB == 7;
	}
	
	
	

}
