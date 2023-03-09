package ita.S05T02N01JanotaFuenteGuido.dados.model.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Document(collection = "players")
@Getter 
@Setter 
@ToString
public class Player {
	
	@Id
	private String id;
	
	@NotNull(message="El nombre del Jugador no puede estar vacio")
	private String name;
	
	private Date registDate;
	
	private double winSuccess;
	
	private int victories;
	
	private List<Game> games;

	
	
	public Player(String name) {
		this.name = name;
		registDate = Calendar.getInstance().getTime();
		winSuccess= 0;
		victories=0;
		games = new ArrayList<Game>();
	}
	

	public void updateWinSuccess() {
		setWinSuccess(winSuccesCalculator());
		
	}
	
	public double winSuccesCalculator() {
		int totalGames = games.size()+ 1; //Se suma 1 para tomar en cuenta la partida actual
		double result=0;
		
		if (totalGames>=1) {
			result = victories/ (double) totalGames*100;
		}
		return (double) Math.round(result * 10d) / 10d;
	}
	
	public void resetPlayer() {
		winSuccess=0;
		victories=0;
		games = new ArrayList<Game>();
		
	}


	

}
