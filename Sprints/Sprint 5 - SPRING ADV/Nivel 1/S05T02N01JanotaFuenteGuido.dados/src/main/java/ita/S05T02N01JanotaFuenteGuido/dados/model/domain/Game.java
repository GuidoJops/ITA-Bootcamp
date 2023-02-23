package ita.S05T02N01JanotaFuenteGuido.dados.model.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name = "games")
public class Game {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "pk_GameId")
	private int id;
	
	@Column(name = "Dice_A")
	private int diceA;
	
	@Column(name = "Dice_B")
	private int diceB;
	
	@Column(name = "Victory")
	private boolean win;
	
	@JsonIgnore
	@ManyToOne(optional = false, 
			cascade = CascadeType.PERSIST, //SAVE se propaga a las entidades relacionadas.
			fetch = FetchType.LAZY) //Objetos de la relacion cargan a demanda
	@JoinColumn(name = "pk_PlayerId", nullable=false)
	private Player player;

	
	public Game() {
		
	}
	
	
	public Game(Player player) {
		this.player = player;
		diceA = (int)(Math.random()*6)+1;
		diceB = (int)(Math.random()*6)+1;
		win = winLose();
	}
	

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

	public boolean getWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	
	@Override
	public String toString() {
		return "Game [idGame=" + id + ", diceA=" + diceA + ", diceB=" + diceB + ", win=" + win + ", player="
				+ player + "]";
	}
	
	public boolean winLose() {
		System.out.println(diceA);
		System.out.println(diceB);
		System.out.println(diceA+diceB);

		return diceA + diceB == 7;
	}
	
	
	

}
