package ita.S05T02N01JanotaFuenteGuido.dados.model.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "players")
public class Player {
	
	@Id
	private String id;
	
	@NotNull(message="El nombre deL Jugador no puede estar vacio")
	private String name;
	
	private Date registDate;
	
	private double winSuccess;
	
	private int victories;
	
	private List<Game> games;

	
	
	public Player() {
		
	}
	
	public Player(String name) {
		this.name = name;
		registDate = Calendar.getInstance().getTime();
		winSuccess= 0;
		victories=0;
		games = new ArrayList<Game>();
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegistDate() {
		return registDate;
	}

	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}

	public double getWinSuccess() {
		return winSuccess;
	}

	public void setWinSuccess(double winSuccess) {
		this.winSuccess = winSuccess;
	}
	
	public int getVictories() {
		return victories;
	}

	public void setVictories(int victories) {
		this.victories = victories;
	}
	

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	@Override
	public String toString() {
		return "Player [idPlayer=" + id + ", name=" + name + ", registDate=" + registDate + ", winSucces="
				+ winSuccess + "]";
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
