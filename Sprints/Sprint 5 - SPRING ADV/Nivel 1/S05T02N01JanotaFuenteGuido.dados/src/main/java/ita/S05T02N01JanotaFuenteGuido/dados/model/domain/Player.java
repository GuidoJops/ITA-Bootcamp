package ita.S05T02N01JanotaFuenteGuido.dados.model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name = "players")
public class Player {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "pk_PlayerId")
	private int id;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Registation_Date")
	private Date registDate;
	
	@Column(name = "Win_Porcentage")
	private double winSuccess;
	
	@OneToMany( mappedBy = "player")
	private List<Game> games;

	
	
	public Player() {
		
	}
	
	public Player(String name) {
		this.name = name;
		registDate = Calendar.getInstance().getTime();
		winSuccess= 0;
		games = new ArrayList<Game>();
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
	
	

}
