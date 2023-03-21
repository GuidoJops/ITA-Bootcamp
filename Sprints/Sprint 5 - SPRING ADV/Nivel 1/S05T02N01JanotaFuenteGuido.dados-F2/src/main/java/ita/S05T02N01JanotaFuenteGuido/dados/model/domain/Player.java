package ita.S05T02N01JanotaFuenteGuido.dados.model.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter 
@ToString
@Document(collection = "players")
public class Player {
	
	@Id
	private String id;
	@NotNull(message="El nombre del Jugador no puede estar vacio")
	//@NotBlank
	private String name;
	private String userName; //E-mail
	private String password;
	private Date registDate;
	private double winSuccess;
	private int victories;
	private List<Game> games;
	private List<Role> roles;

	
	
	public Player() {
		this.name = name;
		this.userName = userName;
		this.password = password;
		registDate = Calendar.getInstance().getTime();
		winSuccess= 0;
		victories=0;
		games = new ArrayList<Game>();
		roles = new ArrayList<Role>();
	}

//	public Player(String name, String userName, String password) {
//		this.name = name;
//		this.userName = userName;
//		this.password = password;
//		registDate = Calendar.getInstance().getTime();
//		winSuccess= 0;
//		victories=0;
//		games = new ArrayList<Game>();
//		roles = new ArrayList<Role>();
//	}
	

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
