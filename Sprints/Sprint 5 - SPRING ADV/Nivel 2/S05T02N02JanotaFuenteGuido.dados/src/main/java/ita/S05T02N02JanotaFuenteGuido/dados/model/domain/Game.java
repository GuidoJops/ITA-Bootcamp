package ita.S05T02N02JanotaFuenteGuido.dados.model.domain;


import lombok.*;

@Getter 
@Setter
@Builder
@AllArgsConstructor
@ToString
public class Game {
	
	private int diceA;
	private int diceB;
	private boolean win;
	
	public Game() {
		diceA = (int)(Math.random()*6)+1;
		diceB = (int)(Math.random()*6)+1;
		win = winLose();
	}

	public boolean winLose() {
		return diceA + diceB == 7;
	}
	
	

}
