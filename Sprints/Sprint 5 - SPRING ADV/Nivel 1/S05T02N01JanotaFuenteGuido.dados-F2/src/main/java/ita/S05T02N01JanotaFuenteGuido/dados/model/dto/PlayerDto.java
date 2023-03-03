package ita.S05T02N01JanotaFuenteGuido.dados.model.dto;


import java.util.Date;



public class PlayerDto {
	
	private String id;
	
	private String name;
	
	private Date registDate;
	
	private double winSuccess;
	
	
	
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
	
	

}
