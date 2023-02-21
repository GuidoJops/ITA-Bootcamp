package ita.S05T02N01JanotaFuenteGuido.dados.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "Game")
public class Game {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "pk_GameId")
	private int idGame;
	
	@Column(name = "Dice_A")
	private int diceA;
	
	@Column(name = "Dice_B")
	private int diceB;
	
	@Column(name = "Victory")
	private boolean win;
	
	@JoinColumn(name = "pk_PlayerId", nullable=false)
	@ManyToOne
	private Player player;

}
