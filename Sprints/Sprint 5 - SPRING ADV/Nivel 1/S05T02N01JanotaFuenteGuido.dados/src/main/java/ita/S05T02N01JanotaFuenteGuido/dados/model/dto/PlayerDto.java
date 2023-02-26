package ita.S05T02N01JanotaFuenteGuido.dados.model.dto;


import java.util.Date;
//import java.util.List;


public class PlayerDto {
	

	private int id;
	private String name;
	private Date registDate;
	private double winSuccess;
	//private List<Game> games;
	
	
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
//	public List<Game> getGames() {
//		return games;
//	}
//	public void setGames(List<Game> games) {
//		this.games = games;
//	}
	
	

}
