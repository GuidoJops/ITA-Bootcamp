package ita.S05T02N02JanotaFuenteGuido.dados.model.domain;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter 
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "players")
public class Player {
	
	@Id
	private String id;
	@NotBlank(message="El nombre del Jugador no puede estar vacio")
	private String name;
	//Se usa e-mail como 'userName'
	@Email(message = "El nombre de usuario debe ser formato e-mail")
	@NotBlank (message = "El nombre de usuario no puede estar vacío")
	private String userName;
	@JsonIgnore
	@NotBlank (message = "La contraseña no puede estar vacía")
	private String password;
	private Date registDate;
	private double winSuccess;
	private int victories;
	private List<Game> games;
	private List<Role> roles;


	public Player(String name, String userName, String password) {
		this.name = name;
		this.userName = userName;
		this.password = password;
		registDate = Calendar.getInstance().getTime();
		winSuccess = 0;
		victories = 0;
		games = new ArrayList<Game>();
		roles = Arrays.asList(
				new Role(2L,ERole.ROLE_USER)); // role de USER por defecto
	}
	

	public void updateWinSuccess() {
		setWinSuccess(winSuccesCalculator());
	}
	
	public double winSuccesCalculator() {
		int totalGames = games.size() + 1; //Se suma 1 para tomar en cuenta la partida actual
		double result = 0;
		
		if (totalGames >= 1) {
			result = victories / (double) totalGames * 100;
		}
		return (double) Math.round(result * 10d) / 10d;
	}
	
	public void resetPlayer() {
		winSuccess = 0;
		victories = 0;
		games = new ArrayList<Game>();
		
	}

}
